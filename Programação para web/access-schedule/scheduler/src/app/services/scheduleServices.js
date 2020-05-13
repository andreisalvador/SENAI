const ScheduleSchema = require('../models/schedule')
const ConfigurationServices = require('../services/configurationServices')
const timeUtils = require('../../utils/time')
const errors = require('../../resources/errors/en.json')

reachedMaxPeopleByPeriodAllowed = (currentSchedule, time, configuration) =>
    getUsersFromScheduleTime(currentSchedule, time).length >= configuration.maxPeopleByPeriod


isBetweenOpeningHours = (time, configuration) =>
    timeUtils.IsBetweenTime(configuration.openAt, configuration.closeAt, time)

isScheduleInSameDay = (currentSchedule, user, time) =>
    !currentSchedule && getUsersFromScheduleTime(currentSchedule, time).includes(user)


getUsersFromScheduleTime = (currentSchedule, time) => currentSchedule.schedules
    .find(schedule => schedule.time == time).users
// IsScheduleInUse = (date, time) => {
//     return await ScheduleSchema.findOne({ 'scheduleDate': date, 'scheduleTime': time }) != null
// }

module.exports = {
    async getById(_id) {
        const schedule = await ScheduleSchema.findById(_id)

        console.log('teste')
        if (!schedule)
            throw errors.scheduleNotFoud

        return schedule
    },
    async getAllWith(scheduleDto) {
        return await ScheduleSchema.find(scheduleDto.filters).select(`+${scheduleDto.selectSubDocuments}`)
    },
    async create(scheduleDto) {
        const configuration = await ConfigurationServices.getById(scheduleDto.companyId)

        if (!isBetweenOpeningHours(scheduleDto.time, configuration))
            throw errors.betweenOpeningHours

        return await ScheduleSchema.create(scheduleDto)
    },
    async update(scheduleDto) {
        const { companyId, date, time, user, schedules, _id } = scheduleDto
        const schedule = await this.getById(_id)
        const configuration = await ConfigurationServices.getById(companyId)

        if (!isBetweenOpeningHours(time, configuration))
            throw errors.betweenOpeningHours

        if (isScheduleInSameDay(schedule, user, time))
            throw errors.scheduleInSameDay

        if (reachedMaxPeopleByPeriodAllowed(schedule, time, configuration))
            throw errors.maxPeopleByPeriod


        return await ScheduleSchema.findOneAndUpdate({ _id }, {
            date,
            schedules
        }, { new: true })
    },
    async delete(_id) {
        return await ScheduleSchema.findByIdAndDelete({ _id })
    },
    async getByCompanyAndDate(companyId, date) {
        return await ScheduleSchema.findOne({ companyId, date })
    }
}
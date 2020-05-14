const ScheduleSchema = require('../models/schedule')
const ConfigurationServices = require('../services/configurationServices')
const timeUtils = require('../../utils/time')
const errors = require('../../resources/errors/en.json')

async function scheduleExistsInDate(date) { return await ScheduleSchema.exists({ date }) }

reachedMaxPeopleByPeriodAllowed = (currentSchedule, time, configuration) =>
    getUsersFromScheduleTime(currentSchedule, time).length >= configuration.maxPeopleByPeriod

isBetweenOpeningHours = (time, configuration) =>
    time != null && timeUtils.IsBetweenTime(configuration.openAt, configuration.closeAt, time)

isScheduleInSameDay = (currentSchedule, user, time) => (user != null && time != null && currentSchedule != null) &&
    getUsersFromScheduleTime(currentSchedule, time).includes(user)

getUsersFromScheduleTime = (currentSchedule, time) =>
    time ? [] : currentSchedule.schedules
        .find(schedule => schedule.time == time).users


module.exports = {
    async getById(_id) {
        const schedule = await ScheduleSchema.findById(_id)

        if (!schedule)
            throw errors.scheduleNotFoud

        return schedule
    },
    async getAllWith(scheduleDto) {
        return await ScheduleSchema.find(scheduleDto.filters).select(`+${scheduleDto.selectSubDocuments}`)
    },
    async create(scheduleDto) {
        const configuration = await ConfigurationServices.getById(scheduleDto.companyId)

        if (await scheduleExistsInDate(scheduleDto.date))
            throw errors.scheduleAlreadyExist

        if (scheduleDto.schedules && !isBetweenOpeningHours(scheduleDto.time, configuration))
            throw errors.betweenOpeningHours

        return await ScheduleSchema.create(scheduleDto)

    },
    async update(_id, scheduleDto) {
        try {
            const { companyId, time, user, schedules } = scheduleDto
            const schedule = await this.getById(_id)
            const configuration = await ConfigurationServices.getById(companyId)

            if (!isBetweenOpeningHours(time, configuration))
                throw errors.betweenOpeningHours

            if (isScheduleInSameDay(schedule, user, time))
                throw errors.scheduleInSameDay

            if (reachedMaxPeopleByPeriodAllowed(schedule, time, configuration))
                throw errors.maxPeopleByPeriod

            await schedule.updateOne({
                'schedules': schedules
            })

            return schedule

        } catch (error) {
            console.log(error)
            if (error.status)
                throw error
            else
                throw {
                    status: 400,
                    description: error
                }
        }
    },
    async delete(_id) {
        return await ScheduleSchema.findByIdAndDelete({ _id })
    },
    async getByCompanyAndDate(companyId, date) {
        return await ScheduleSchema.findOne({ companyId, date })
    }
}
const moment = require('moment')

toMinutes = (time) => (time.hours() * 60) + time.minutes();

module.exports = {
    IsBetweenTime(start, end, value) {
        const currentTime = moment(new Date(`1900-01-01 ${value}:00`))
        const startTime = moment(new Date(`1900-01-01 ${start}:00`))
        const endTime = moment(new Date(`1900-01-01 ${end}:00`))

        return currentTime >= startTime || currentTime <= endTime
    }
}
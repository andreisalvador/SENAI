const mongoose = require('../../database/index')

toDate = (value) => new Date(value)

const SchedulesSchema = new mongoose.Schema({
    time: {
        type: String,
        required: true,
        unique: true
    },
    users: [String]

})

const ScheduleSchema = new mongoose.Schema({
    companyId: {
        type: mongoose.Schema.Types.ObjectId,
        unique: true,
        required: true
    },
    date: {
        type: String,
        unique: true,
        get: toDate
    },
    schedules: [SchedulesSchema]
})

ScheduleSchema.pre('save', async function (next) {

    if (!mongoose.Types.ObjectId.isValid(this.companyId))
        throw 'Invalid company id.'

    next()
})

module.exports = mongoose.model('Schedule', ScheduleSchema)
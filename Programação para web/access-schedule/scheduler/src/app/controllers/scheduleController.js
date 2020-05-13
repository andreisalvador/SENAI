const ScheduleServices = require('../services/scheduleServices')


module.exports = {
    async getById(req, res) {
        try {            
            res.send(await ScheduleServices.getById(req.body._id))
        } catch (error) {
            res.status(err.status).send(err.description)
        }
    },
    async getAll(req, res) {
        res.send(await ScheduleServices.getAll())
    },
    async createOrUpdate(req, res) {
        try {
            res.send(await ScheduleServices.createOrUpdate(req.body))
        } catch (err) {
            res.status(err.status).send(err.description)
        }
    },
    async delete(req, res) {
        const scheduleDeleted = await ScheduleServices.delete(req.params.id)
        res.send(scheduleDeleted)
    }
}
module.exports = {
    async getById(Services, req, res) {
        try {                        
            res.send(await Services.getById(req.params._id))
        } catch (error) {            
            res.status(error.status).send(error.description)
        }
    },
    async create(Services, req, res) {
        try {
            res.send(await Services.create(req.body))
        } catch (error) {
            res.status(error.status).send(error.description)
        }
    },
    async update(Services, req, res) {
        try {
            res.send(await Services.update(req.params._id, req.body))
        } catch (error) {
            res.status(error.status).send(error.description)
        }
    },
    async delete(Services, req, res) {
        try {
            res.send(await Services.delete(req.params._id))
        } catch (error) {
            res.status(error.status).send(error.description)
        }
    },
    async getAllWith(Services, req, res) {
        try {                        
            console.log('tete')
            res.send(await Services.getAllWith(req.body))
        } catch (error) {
            res.status(error.status).send(error.description)
        }
    }
}
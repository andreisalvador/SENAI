const ConfigurationServices = require('../services/configurationServices')
const baseController = require('../controllers/base/baseController')

module.exports = {
    async getById(req, res) {
        return await baseController.getById(ConfigurationServices, req, res)
    } 
}

// module.exports = {
//     async getById(req, res) {
//         try {
//             res.send(ConfigurationServices.getById(req.body._id))
//         } catch (error) {
//             res.status(error.status).send(error.description)
//         }
//     },
//     async create(req, res) {
//         try {
//             res.send(ConfigurationServices.create(req.body))
//         } catch (error) {
//             res.status(error.status).send(error.description)
//         }
//     },
//     async update(req, res) {
//         try {
//             res.send(ConfigurationServices.update(req.params._id, req.body))
//         } catch (error) {
//             res.status(error.status).send(error.description)
//         }
//     },
//     async delete(req, res) {
//         try {
//             res.send(ConfigurationServices.delete(req.params._id))
//         } catch (error) {
//             res.status(error.status).send(error.description)
//         }
//     }
// }
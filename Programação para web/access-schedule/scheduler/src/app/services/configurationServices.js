const ConfigurationSchema = require('../models/configuration')
const errors = require('../../resources/errors/en.json')

module.exports = {
    async getById(_id) {
        try {
            const configuration = await ConfigurationSchema.findById(_id)

            if (!configuration)
                throw errors.configurationNotFound

            return configuration
        } catch (error) {
            throw {
                status: 400,
                description: error
            }
        }

    },
    async create(configurationDto) {
        try {
            const configuration = await ConfigurationSchema.create(configurationDto)
            return configuration
        } catch (error) {
            throw {
                status: 400,
                description: error
            }
        }
    },
    async update(_id, configurationDto) {
        try {
            const configuration = await ConfigurationSchema.findByIdAndUpdate(_id, configurationDto, { new: true }).select('+locationName')

            if (!configuration)
                throw errors.configurationNotFound

            return configuration
        } catch (error) {
            throw {
                status: 400,
                description: error
            }
        }
    },
    async delete(_id) {
        try {
            const configuration = await ConfigurationSchema.findByIdAndDelete({ _id })

            if (!configuration)
                throw errors.configurationNotFound

            return configuration
        } catch (error) {

        }
    },
    async getAllWith(configurationDto) {
        return await ConfigurationSchema.find(configurationDto.filters).select(`+${configurationDto.selectSubDocuments}`)
    }
}
const ConfigurationSchema = require('../models/configuration')

module.exports = {
    async getById(_id) {
        const configuration = ConfigurationSchema.getById(_id)

        if (!configuration)
            throw errors.configurationNotFound

        return configuration
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
            const configuration = await ConfigurationSchema.findByIdAndUpdate({ _id }, { configurationDto })

            if (!configuration)
                throw ''

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
                throw ''

            return configuration
        } catch (error) {

        }
    },
    async getAllWith(configurationDto){
        return await ConfigurationSchema.find(configurationDto.filters).select(`+${configurationDto.selectSubDocuments}`)
    }
}
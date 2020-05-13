const mongoose = require('../../database/index')

const ConfigurationSchema = new mongoose.Schema({
    locationName:{
        type: String,
        require: true,
        select: false
    },
    maxPeopleByPeriod: {
        type: Number,
        require: true
    },
    maximumStayTime: {
        type: Number,
        require: true
    },
    openAt: {
        type: String,
        require: true
    },
    closeAt: {
        type: String,
        require: true
    },
    usersAllowed: [{
        user: String
    }]
})


ConfigurationSchema.pre('save', async function(next){
    console.log(this._id)
    next()
})

module.exports = mongoose.model('Configuration', ConfigurationSchema)
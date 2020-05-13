const mongoose = require('mongoose');

mongoose.connect('mongodb+srv://andrei_salvador:mongo786451@cluster0-rz2hu.mongodb.net/test?retryWrites=true&w=majority', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false
});
mongoose.Promise = global.Promise;

module.exports = mongoose;

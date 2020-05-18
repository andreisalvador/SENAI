const app = require('express')()
const routes = require('./routes')
const bodyParser = require('body-parser')
require('dotenv').config({ path: path.resolve(__dirname, '../.env') })

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))
app.use(routes)

app.listen(process.env.PORT || 3000)

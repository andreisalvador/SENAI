const express = require('express')
const SheduleServices = require('./app/services/scheduleServices')
const ConfigurationServices = require('./app/services/ConfigurationServices')

const genericController = require('./app/controllers/base/baseController')

const routes = express.Router();

const scheduleRoute = process.env.SCHEDULE_ROUTE || 'schedule'
const configurationRoute = process.env.CONFIG_ROUTE || 'configurations'

routes.post(`/${scheduleRoute}/`, (req, res) => genericController.create(SheduleServices, req, res));
routes.get(`/${scheduleRoute}/:_id`, (req, res) => genericController.getById(SheduleServices, req, res));
routes.post(`/${scheduleRoute}/company/`, (req, res) => genericController.getAllWith(SheduleServices, req, res));
routes.put(`/${scheduleRoute}/:_id`, (req, res) => genericController.update(SheduleServices, req, res));
routes.delete(`/${scheduleRoute}/:_id`, (req, res) => genericController.delete(SheduleServices, req, res));

routes.post(`/${configurationRoute}/`, (req, res) => genericController.create(ConfigurationServices, req, res))
routes.get(`/${configurationRoute}/:_id`, (req, res) => genericController.getById(ConfigurationServices, req, res));
routes.post(`/${configurationRoute}/filterConfigs/`, (req, res) => genericController.getAllWith(ConfigurationServices, req, res));
routes.put(`/${configurationRoute}/:_id`, (req, res) => genericController.update(ConfigurationServices, req, res))
routes.delete(`/${configurationRoute}/:_id`, (req, res) => genericController.delete(ConfigurationServices, req, res));

module.exports = routes;
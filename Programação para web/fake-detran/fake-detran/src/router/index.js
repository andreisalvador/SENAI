import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import Details from '../views/Details.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'main',
    component: Main
  },
  {
    path: '/details/:placa', component: Details
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

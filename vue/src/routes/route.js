
import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../components/Index"
import Register from "../views/Register"
import Login from "../views/Login"
import Example from "../views/Example"

Vue.use(VueRouter);
const router =  new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: '/index',
        },
        {
            path: '/index',
            name: 'index',
            component: Index
        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/example',
            name: 'example',
            component: Example
        },
    ]
});

export {router}

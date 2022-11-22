
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import StoreManager from "./components/listers/StoreCards"
import StoreDetail from "./components/listers/StoreDetail"

import DeilveryManager from "./components/listers/DeilveryCards"
import DeilveryDetail from "./components/listers/DeilveryDetail"

import NotifyLogManager from "./components/listers/NotifyLogCards"
import NotifyLogDetail from "./components/listers/NotifyLogDetail"

import MyDeliveryInfoView from "./components/MyDeliveryInfoView"
import MyDeliveryInfoViewDetail from "./components/MyDeliveryInfoViewDetail"
import PointManager from "./components/listers/PointCards"
import PointDetail from "./components/listers/PointDetail"

import PointInfoView from "./components/PointInfoView"
import PointInfoViewDetail from "./components/PointInfoViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/stores',
                name: 'StoreManager',
                component: StoreManager
            },
            {
                path: '/stores/:id',
                name: 'StoreDetail',
                component: StoreDetail
            },

            {
                path: '/deilveries',
                name: 'DeilveryManager',
                component: DeilveryManager
            },
            {
                path: '/deilveries/:id',
                name: 'DeilveryDetail',
                component: DeilveryDetail
            },

            {
                path: '/notifyLogs',
                name: 'NotifyLogManager',
                component: NotifyLogManager
            },
            {
                path: '/notifyLogs/:id',
                name: 'NotifyLogDetail',
                component: NotifyLogDetail
            },

            {
                path: '/myDeliveryInfos',
                name: 'MyDeliveryInfoView',
                component: MyDeliveryInfoView
            },
            {
                path: '/myDeliveryInfos/:id',
                name: 'MyDeliveryInfoViewDetail',
                component: MyDeliveryInfoViewDetail
            },
            {
                path: '/points',
                name: 'PointManager',
                component: PointManager
            },
            {
                path: '/points/:id',
                name: 'PointDetail',
                component: PointDetail
            },

            {
                path: '/pointInfos',
                name: 'PointInfoView',
                component: PointInfoView
            },
            {
                path: '/pointInfos/:id',
                name: 'PointInfoViewDetail',
                component: PointInfoViewDetail
            },


    ]
})

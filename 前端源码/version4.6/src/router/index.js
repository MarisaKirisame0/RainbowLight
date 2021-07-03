import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/passage',
    name: 'Passage',
    component: () => import(/* webpackChunkName: "about" */ '../views/Passage.vue')
  },
  {
    path: '/fileplace',
    name: 'Fileplace',
    component: () => import(/* webpackChunkName: "about" */ '../views/Fileplace.vue')
  },
  {
    path: '/typecategory',
    name: 'TypeCategory',
    component: () => import(/* webpackChunkName: "about" */ '../views/TypeCategory.vue')
  },
  {
    path: '/tagscategory',
    name: 'TagsCategory',
    component: () => import(/* webpackChunkName: "about" */ '../views/TagsCategory.vue')
  },
  {
    path: '/postquery',
    name: 'PostQuery',
    component: () => import(/* webpackChunkName: "about" */ '../views/PostQuery.vue')
  },
  {
    path: '/friendlink',
    name: 'FriendLink',
    component: () => import(/* webpackChunkName: "about" */ '../views/FriendLink.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router

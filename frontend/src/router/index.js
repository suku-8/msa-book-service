import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/writes',
      component: () => import('../components/ui/WriteGrid.vue'),
    },
    {
      path: '/books',
      component: () => import('../components/ui/BookGrid.vue'),
    },
    {
      path: '/authorInfos',
      component: () => import('../components/ui/AuthorInfoGrid.vue'),
    },
    {
      path: '/coverDesigns',
      component: () => import('../components/ui/CoverDesignGrid.vue'),
    },
    {
      path: '/contentAnalyzers',
      component: () => import('../components/ui/ContentAnalyzerGrid.vue'),
    },
    {
      path: '/points',
      component: () => import('../components/ui/PointGrid.vue'),
    },
    {
      path: '/libraries',
      component: () => import('../components/ui/LibraryGrid.vue'),
    },
    {
      path: '/myLibraries',
      component: () => import('../components/ui/MyLibraryGrid.vue'),
    },
    {
      path: '/subscribers',
      component: () => import('../components/ui/SubscriberGrid.vue'),
    },
    {
      path: '/authors',
      component: () => import('../components/ui/AuthorGrid.vue'),
    },
  ],
})

export default router;

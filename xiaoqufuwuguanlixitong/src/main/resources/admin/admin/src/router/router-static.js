import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import anbao from '@/views/modules/anbao/list'
    import anbaoFenpei from '@/views/modules/anbaoFenpei/list'
    import chat from '@/views/modules/chat/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fangwu from '@/views/modules/fangwu/list'
    import fankiu from '@/views/modules/fankiu/list'
    import forum from '@/views/modules/forum/list'
    import gonggao from '@/views/modules/gonggao/list'
    import weixui from '@/views/modules/weixui/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuangong from '@/views/modules/yuangong/list'
    import config from '@/views/modules/config/list'
    import dictionaryAnbaoFenpei from '@/views/modules/dictionaryAnbaoFenpei/list'
    import dictionaryChat from '@/views/modules/dictionaryChat/list'
    import dictionaryFangwu from '@/views/modules/dictionaryFangwu/list'
    import dictionaryFankiu from '@/views/modules/dictionaryFankiu/list'
    import dictionaryFankiuZhuangtai from '@/views/modules/dictionaryFankiuZhuangtai/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryLoudong from '@/views/modules/dictionaryLoudong/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'
    import anpai from '@/views/modules/weixui/add-or-update'
    import fenpei from '@/views/modules/anbaoFenpei/add-or-update'






//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryAnbaoFenpei',
        name: '安排类型',
        component: dictionaryAnbaoFenpei
    }
    ,{
        path: '/dictionaryChat',
        name: '数据类型',
        component: dictionaryChat
    }
    ,{
        path: '/dictionaryFangwu',
        name: '房屋类型',
        component: dictionaryFangwu
    }
    ,{
        path: '/dictionaryFankiu',
        name: '反馈类型',
        component: dictionaryFankiu
    }
    ,{
        path: '/dictionaryFankiuZhuangtai',
        name: '反馈状态',
        component: dictionaryFankiuZhuangtai
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryLoudong',
        name: '楼栋',
        component: dictionaryLoudong
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '状态',
        component: dictionaryZhuangtai
    }
    ,{
        path: '/anpai',
        name: '安排',
        component: anpai
    }
        ,{
            path: '/fenpei',
            name: '分配',
            component: fenpei
        }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/anbao',
        name: '安保',
        component: anbao
      }
    ,{
        path: '/anbaoFenpei',
        name: '安保分配',
        component: anbaoFenpei
      }
    ,{
        path: '/chat',
        name: '客服聊天',
        component: chat
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/fangwu',
        name: '房屋',
        component: fangwu
      }
    ,{
        path: '/fankiu',
        name: '反馈',
        component: fankiu
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/weixui',
        name: '反馈处理',
        component: weixui
      }
    ,{
        path: '/yonghu',
        name: '住户',
        component: yonghu
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;

const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoqufuwuguanlixitong/",
            name: "xiaoqufuwuguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoqufuwuguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "小区服务管理系统"
        } 
    }
}
export default base

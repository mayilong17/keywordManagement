function del(id) {
    var flang=confirm("确定删除这条信息吗?");
    if(flang==true){
        location.href='/keywordManagement/findAllServlet?id='+id+'&comm=del';
    }
}

function add() {
    location.href='addUser.jsp';
}
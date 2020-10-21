# JS模板

## 步骤
引入JS
```
<script src="../js/mustache.js" type="text/javascript"></script>
<script src="../js/mustacheextends.js" type="text/javascript"></script>
```
HTML片段
```html
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <th scope="col">序号</th>
        <th scope="col">用户名</th>
        <th scope="col">登录名</th>
        <th scope="col">密码</th>
        <th scope="col">手机号</th>
        <th scope="col">查看</th>
    </tr>
    </thead>
    <tbody id="user-list">

    </tbody>
</table>
```
JS片段
```js
faep.execute("user/findAllUsers", null, function (ret){
            var data = {"users": ret};
            var userListHtml = htmlRender($("#userlist-template").html(), data);
            $("#user-list").html(userListHtml);
        });
```
```html
<script type="text/x-template" id="userlist-template">
    {{#users}}
    <tr>
        <td scope="row">1</td>
        <td>{{username}}</td>
        <td>{{loginid}}</td>
        <td>{{password}}</td>
        <td>{{phone}}</td>
        <td>
            <svg style="cursor: pointer;" onclick="openUser('{{rowguid}}')" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-search" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
                <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
            </svg>
        </td>
    </tr>
    {{/users}}
</script>
```
后台示例：
```java
@RestController
@RequestMapping("/user")
@Scope("request")
public class UserController{
    /**
     * 获取所有的用户数据
     */
    @PostMapping(value = "/findAllUsers")
    public List<User> findAllUsers() {
        List<User> users = userService.findAllUsers();
        logger.info("查询所有用户成功！");
        return users;
    }
}
```




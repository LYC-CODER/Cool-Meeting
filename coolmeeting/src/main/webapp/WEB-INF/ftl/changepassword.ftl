<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
    </head>
    <body>
    <#include "top.ftl">
        <div class="page-body">
            <#include "liftMenu.ftl">
            <div class="page-content">
                <div class="content-nav">
                    修改密码
                </div>
                <form action="/dochange" method="post">
                    <fieldset>
                        <legend>修改密码信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>账号:</td>
                                <td>
                                    <input id="username" name="username" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>原密码:</td>
                                <td>
                                    <input id="username" name="password" type="password" />
                                </td>
                            </tr>
                            <tr>
                                <td>新密码：</td>
                                <td>
                                    <input id="username" name="newpassword" type="password"/>
                                </td>
                            </tr>
                            <div style="color: #ff0114">${error!''}</div>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton"/>
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:2917905862@qq.com">管理员</a>
            <img src="/images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>

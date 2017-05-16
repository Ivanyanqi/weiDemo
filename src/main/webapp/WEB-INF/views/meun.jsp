<%--
  Created by IntelliJ IDEA.
  User: 仙人球
  Date: 2017/5/14
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="tpl-left-nav tpl-left-nav-hover">
        <%--<div class="tpl-left-nav-title">

        </div>--%>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="${pageContext.request.contextPath}/toWelPage" class="nav-link active">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="chart.html" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bar-chart"></i>
                        <span>数据表</span>
                        <i class="tpl-left-nav-content tpl-badge-danger">
                            12
                        </i>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>素材管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" id="media-manager">
                        <li>
                            <a href="${pageContext.request.contextPath}/toMediaList">
                                <i class="am-icon-angle-right"></i>
                                <span>素材列表</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>

                            <a href="${pageContext.request.contextPath}/toUploadPage">
                                <i class="am-icon-angle-right"></i>
                                <span>素材上传</span>
                                <i class="tpl-left-nav-content tpl-badge-success">
                                    18
                                </i>
                            </a>
                                <a href="form-news.html">
                                    <i class="am-icon-angle-right"></i>
                                    <span>消息列表</span>
                                    <i class="tpl-left-nav-content tpl-badge-primary">
                                        5
                                    </i>
                                </a>

                                    <a href="form-news-list.html">
                                        <i class="am-icon-angle-right"></i>
                                        <span>文字列表</span>

                                    </a>
                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>表单</span>
                        <%-- tpl-left-nav-more-ico-rotate 向下的箭头，  --%>
                        <%--<i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>--%>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" >
                        <li>
                            <a href="form-amazeui.html">
                                <i class="am-icon-angle-right"></i>
                                <span>Amaze UI 表单</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>

                            <a href="form-line.html">
                                <i class="am-icon-angle-right"></i>
                                <span>线条表单</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="${pageContext.request.contextPath}/userList" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-key"></i>
                        <span>用户管理</span>
                    </a>
                </li><li class="tpl-left-nav-item">
                    <a href="${pageContext.request.contextPath}/toRegisterPage" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-key"></i>
                        <span>用户注册</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>


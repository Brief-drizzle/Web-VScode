<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!-- https://blog.csdn.net/qq_43620805/article/details/107969267 -->
<!doctype html>
<html lang="zh">
<head>
    <title>js调用摄像头拍照上传图片</title>
    <meta charset="utf-8">
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Getface.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<style>
    .getface{
        position: absolute;
        top: 20%;
        left: 35%;

    }
    .tishi{
        font-size: 20px;

    }
</style>
<body>
<div align="center">
    <p id="flag" class="tishi"></p>
</div>
<div class="getface">
    <video id="video" width="400px" height="400px" autoplay="autoplay"></video>
    <canvas id="canvas" width="400px" height="400px" style="display: none;"></canvas>
    <img id="imgTag" src="" alt="imgTag" style="display: none;">
</div>
</body>
<!DOCTYPE html>
<html lang="en">
<head>
    <title> eSewa email</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            font-family: arial, serif;
        }

        body {
            background-color: #fafafa;
        }

        .clearfix:after {
            visibility: hidden;
            display: block;
            font-size: 0;
            content: " ";
            clear: both;
            height: 0;
        }

        .left {
            float: left;
        }

        .right {
            float: right;
        }

        .container {
            width: 700px;
            margin: 0 auto;
        }

        .text-center {
            text-align: center;
        }

        .text-right {
            text-align: right
        }

        .text-left {
            text-align: left;
        }

        a {
            list-style: none;
        }

        p {
            text-align: justify;
        }

        h3 {
            font-size: 15px;
            padding-top: 20px;
        }

        .msg-header {
            margin: 0 auto;
            padding: 10px 0;
            text-align: center;
        }

        .msg-header img {
            width: 140px;
        }

        .msg-body {
            border-radius: 2px;
            background-color: #fff;
            padding: 30px
        }

        .msg-body h2 {
            font-family: "Helvetica Neue", sans-serif;
            color: #444;
            display: block;
            font-size: 16px;
            font-weight: 600;
            line-height: 1.4;
            margin: 0;
        }

        .msg-body p {
            margin: 15px 0;
            line-height: 1.4;
            color: #6b6b6b;
            font-weight: 500;
        }

        .msg-body .es-name {
            font-weight: 700;
            padding-top: 10px;
        }

        .msg-body .es-slogan {
            font-size: 14px;
            padding-bottom: 10px;
            color: #999;
        }

        .msg-body .es-services {
            position: relative;
        }

        .msg-body .es-service-inner {
            color: #999;
        }

        .msg-body .es-vr-line {
            height: 2px;
            width: 100%;
            display: none;
            top: 15px;
            background-color: #e9e9e9;
        }

        .es-servicelist > ul > li {
            float: left;
            list-style: none;
            border-right: 1px solid black;
            padding-right: 10px;
            padding-left: 10px;
        }

        .es-service {
            width: 100%;
            margin: 0 auto;
            text-align: center;
        }

        .es-servicelist {
            width: 100%;
            margin: 0 auto;
            font-size: 8px;
            padding-bottom: 15px;
            padding-top: 15px;
            color: #61BB46;
            text-align: center;
        }

        .es-servicelist img {
            width: 100%;
            margin-top: 10px;
        }

        .msg-footer {
            width: 100%;
            margin: 0 auto;
            padding-top: 3px;
            height: 72px;
        }

        .msg-footer > .appstore > .logos > ul > li {
            list-style: none;
            float: left;
            font-size: 8px;
        }

        .logos {
            width: 100%;
            padding-right: 10px;
        }

        .es-address {
            width: 100%;
            text-align: center;
            font-size: 12px;
            color: #989898;
            margin-top: 10px;
        }

        .es-sociallink,
        .es-appstore {
            width: 50%;
            padding-top: 15px;
            padding-bottom: 15px;
        }

        .es-service-inner h3 {
            padding: 10px;
            background: #fff;
            border-bottom: 2px solid #e9e9e9;
        }

        .es-msg-title {
            color: #989898;
            margin-bottom: 5px;
        }

        .es-link img,
        .es-icon img {
            width: 18px;
            margin-right: 10px;
        }

        .es-banner img {
            width: 100%;
        }

        .buttondiv {
            width: 100%;
            margin: 0 auto;
            padding-left: 163px;
            padding-bottom: 10px;
            padding-top: 10px;
        }

        .button {
            border-radius: 8px;
            padding: 10px 24px;
            background-color: green;
            color: white;
        }

        table {
            display: table;
            width: 100%;
        }

        tbody {
            display: table-row-group;
            vertical-align: middle;
        }

        .es-btn-grp {
            text-align: center;
            padding: 10px 0;
            margin-top: 15px;
        }

        .es-btn-grp a {
            font-size: 14px;
            font-weight: bold;
            color: #fff;
            background: #60bb48;
            text-decoration: none;
            border-radius: 5px;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            -o-border-radius: 5px;
            padding: 12px 20px;
        }

        .es-btn-grp a:hover {
            opacity: 0.8;
        }

        .es-hint-txt {
            margin-top: 30px;
            color: #454545;
        }

        .es-trans-name {
            font-size: 15px;
            font-weight: bold;
            color: #5a5a5a;
            text-align: center;
            padding: 10px 0;
        }

        .es-npr {
            font-size: 14px;
            font-weight: 700;
            margin-left: 2px;
        }

        code {
            font-family: monospace !important;
        }
        .es-fs-12 {
            font-size: 12px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #f5f7fd ;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}

        th {
            background-color: #41A124;
            color: white;
        }
    </style>
</head>
<body>
<table>
    <tbody>
    <tr>
        <td>
            <div class="container">
                <div class="msg-header">
                    <img src="https://cdn.esewa.com.np/ui/images/logos/esewa-logo.png" alt="eSewa-logo">
                </div>
                <div class="msg-body">
                    <#include "${templateName}">
                    <h3>Thank You !!!</h3>
                    <div class="es-name">eSewa</div>
                    <div class="es-slogan">Pay | Send | Receive</div>

                    <div class="es-service">
                        <div class="es-services">
                            <div class="es-vr-line">
                            </div>
                            <div class="es-service-inner">
                                <h3>eSewa Services</h3>
                            </div>
                        </div>
                        <a href="https://esewa.com.np" target="_blank">
                            <div class="es-servicelist"><img src="https://cdn.esewa.com.np/ui/images/email/services.png"
                                                             width="680px" alt="services"></div>
                        </a>
                    </div>

                    <div class="es-banner">
                        <div class="es-img-ads">
                            <a href="https://bit.ly/darazeSewa" target="_blank"><img
                                        src="https://cdn.esewa.com.np/ui/images/email/Bigmart.png" alt="bigmart"></a>
                        </div>
                    </div>
                </div>

                <div class="msg-footer">
                    <div class="es-address">
                        eSewa Fonepay Pvt. Ltd. Hattisar, Kathmandu, Nepal Toll Free: 1660-01-02121, Viber:
                        +977-1234512345
                        <br> csd@esewa.com.np, crm@esewa.com.np
                    </div>

                    <div class="es-sociallink text-left clearfix left">
                        <div class="es-msg-title">
                            <h6>Connect with us</h6>
                        </div>
                        <div class="es-link">
                            <a href="https://goo.gl/X0ZRu7" target="_blank"><img
                                        src="https://cdn.esewa.com.np/ui/images/email/facebook.png" alt="facebook"></a>
                            <a href="https://goo.gl/q25nLD" target="_blank"><img
                                        src="https://cdn.esewa.com.np/ui/images/email/tweeter.png" alt="twitter"></a>
                            <a href="skype:esewa.nepal?chat"><img
                                        src="https://cdn.esewa.com.np/ui/images/email/skype.png" alt="skype"></a>
                        </div>

                    </div>

                    <div class="es-appstore text-right right">
                        <div class="es-msg-title">
                            <h6>Download eSewa App</h6>
                        </div>
                        <div class="es-icon">
                            <ul>
                                <a href="https://goo.gl/bQAZmt" target="_blank"><img
                                            src="https://cdn.esewa.com.np/ui/images/email/playstore.png"
                                            alt="playstore"></a>
                                <a href="https://goo.gl/Ltwtqk" target="_blank"><img
                                            src="https://cdn.esewa.com.np/ui/images/email/appstore.png" alt="appstore"></a>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>

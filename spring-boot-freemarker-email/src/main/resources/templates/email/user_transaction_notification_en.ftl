<div>
    <h5>Dear <#if recipientName??>${recipientName}</#if>,</h5>
    <p>Thank you for the payment. The details are as follows: </p>
    <table>
        <thead>
        <tr>
            <th>Merchant Name</th>
            <th>Transaction Date</th>
            <th>Transaction Code</th>
            <th>Transaction Amount (NPR)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <#if productName??>
                <td>${productName}</td>
            <#else>
                <td></td>
            </#if>

            <#if transactionDate??>
                <td>${transactionDate}</td>
            <#else>
                <td></td>
            </#if>

            <#if transactionId??>
                <td>${transactionId}</td>
            <#else>
                <td></td>
            </#if>

            <#if transactionAmount??>
                <td>${transactionAmount}</td>
            <#else>
                <td></td>
            </#if>
        </tbody>
    </table>
    <p><b>
            To view more details, please login to eSewa app and tap on Statement or <#if viewMoreUrl??><a href="${viewMoreUrl}">click here</a></#if> to view statement.
        </b></p>
</div>
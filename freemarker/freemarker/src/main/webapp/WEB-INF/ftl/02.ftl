<#macro book>
    JavaEE
</#macro>
<#macro hello name>
    hello ${name}
</#macro>
<#macro books bs author>
    <#nested>
    <table>
        <#list bs as book>
            <tr>
                <td>${book}</td>
                <td>${author}</td>
            </tr>
        </#list>
    </table>
</#macro>
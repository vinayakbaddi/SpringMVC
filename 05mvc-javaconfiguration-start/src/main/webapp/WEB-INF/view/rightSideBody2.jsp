<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="app-right">
	<c:import url="courseCredits.jsp"/>
    <div class="divider"></div>
	<div class="clear"></div>
    <div class="contact-mobile">
        <div class="phoneicon">
        	<ul>
                <li>INDIA : ${aboutUs.contactSupport}</li>
                <li class="email-resposive">Email Us :
                    <a title="Click to send us a mail" href="https://mail.google.com/mail/u/0/?view=cm&fs=1&to=${aboutUs.email}&tf=1" target="_blank">${aboutUs.email}</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="divider"></div>
	<c:import url="submitQuery.jsp"/>
   <div class="divider"></div>             
</div>

</div> 
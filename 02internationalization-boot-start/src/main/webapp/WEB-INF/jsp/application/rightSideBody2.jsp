<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="app-right">
	<c:import url="/WEB-INF/jsp/application/courseCredits.jsp"/>
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
	<c:import url="/WEB-INF/jsp/application/submitQuery.jsp"/>
   <div class="divider"></div>             
</div>
<div id="rightSideBody" class="app-right">   
<div class="course-features" id="CourseFeature">
		<div class="sub-head">Course Features</div>
	<ul class="course-features">                        
         <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Videos Duration : ${course.durationInHours} Hrs</li>
           <p><span>This is the duration of the course in hours.
           For each topic there is a video, document with the instructions how to progrma which is shown in the video.
           There is problem program as well as solution program. All these documents, problem and solution you can download from the course topics</span></p>
               
         <li><i>+</i><span class="dna-icon"></span>&nbsp;&nbsp;Hands on:   ${course.durationInHours} Hrs</li>
           <p><span>If you purchase the course videos, You will get not only the videos but also documentation, problem and solution programs also.
           All you have to do is read the instructions in the document corresponding to the topic, then implement it in -start projects given to you..
                      If you are thinking that it's difficult to implement the solution, don't worry we have attached the solution also with the document.</span></p>
               
         <li><i>+</i><span class="clock-icon"></span>&nbsp;&nbsp;Course Access Duration</li>
           <p><span>Once you purchase the course, you can view the course for for life time on the same machine. If machine is changed or
            you have re-installed the Operating system, you will not be able to play the videos with same password.You have to purchase the course again.
            We dont provide the new password again for another machine ID for free.
           For more details please contact us @${aboutUs.contactSupport}(Siva)</span></p>
               
         <li><i>+</i><span class="clock-support"></span>&nbsp;&nbsp;Call Us</li>
           <p><span>Now you can call us at extended time periods 8AM IST to 8PM IST from monday to satueday @ ${aboutUs.contactSupport}(Siva)</span></p>
               
         <li><i>+</i><span class="certificate-icon"></span>&nbsp;&nbsp;Become Partner! Earn Money!</li>
           <p><span>Now you can become partner of way2learn software Pvt. Ltd. All you need to do is refer us to your company, 
           and start getting flat 10% of all transactions that we will do with your company for next 3 years. You need not 
           pay any money to become partner in Way2Learn Software Pvt. Ltd</span></p>
	</ul>
 </div>
 <div class="divider"></div> 
 <c:import url="/WEB-INF/jsp/application/courseCredits.jsp"/>
</div> 
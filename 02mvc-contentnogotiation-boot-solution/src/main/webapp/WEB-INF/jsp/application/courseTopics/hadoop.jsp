<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="course-features" id="CourseFeature">
	<ul class="course-features">     
		 <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;All Presentations Download</li>
           <p>
	           	<span>
	           	<c:if test="${SPRING_SECURITY_CONTEXT!=null}">
	           		Download the password protected Presentations here :
	          		<a href="http://resources.way2learn.co.in/hadoop/ppts-pdf.zip" > Presentations  </a><br/><br/>
	           	</c:if>
	           	
	           	<c:if test="${SPRING_SECURITY_CONTEXT==null}">
						Please <a   href="javascript:signIn()"  style="color: blue; text-decoration: underline;" >SIGN IN</a> to  Download the Presentations
					</c:if>
	          		
	          		
	           	</span>
           </p>   
           
            <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;All Lab Documentation Download</li>
           <p>
	           	<span>
	           		<c:if test="${SPRING_SECURITY_CONTEXT!=null}">
		          		Download the password protected Lab Documents here :
		          		<a href="http://resources.way2learn.co.in/hadoop/ppts-pdf.zip" > Lab Exercise Documentation  </a><br/><br/>
	          		</c:if>
	          		<c:if test="${SPRING_SECURITY_CONTEXT==null}">
						Please <a   href="javascript:signIn()"  style="color: blue; text-decoration: underline;" >SIGN IN</a> to  Download the Lab Documentation
					</c:if>
	           	</span>
           </p>  
           
            <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;All Lab Code Download</li>
           <p>
	           	<span>
	          		Download the Lab Code  here :
	          		<a href="http://resources.way2learn.co.in/hadoop/ppts-pdf.zip" > Lab Code  </a><br/><br/>
	          		
	           	</span>
           </p>   
            
           
                           
         <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Overview of the Hadoop Tutorial Series</li>
           <p>
	           	<span>
	          		This course will teach you hadoop starting from basics to advanced Level.
	          		All you have to do is to see the video for each module, work on the lab exercises.<br/>
	          		
	           	</span>
           </p>
               
         <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Introduction to Big Data</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/01BigDataIntro.exe">Video </a><br/>
					
			   </span>
		   </p>
               
         <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Basics of Hadoop</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/02HadoopBasics.exe" >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Creating Ubuntu VM using VMWare WorkStation</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/03CreatingUbuntuVMusingVMWareWorkStation.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Installing 2 node Hadoop 1.x cluster</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/04Installing2nodehadoop1cluster.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; HDFS Basics</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/05HDFSBasics.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;About Secondary Namenode in detail</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/06SecondaryNamenode.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Setting up development environment </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/07Settingupdevelopmentenvironment.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;Basic HDFS Commands </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/08BasicHdfsCommands.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Accessing HDFS using Java API </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/09AccessingHDFSusingJavaAPI.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		   <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Mapreduce Basics   </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/10MapreduceBasics.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		   <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Using Tool Runner and New Hadoop API  </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/11ToolRunnerandNewAPI.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Combiner and Custom Partitioner </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/12CombinerandCustomPartitioner.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Mapreduce in detail </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/13Mapreduceindetail.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  CustomWritable and WritableComparable </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/14CustomWritableandWritableComparable.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;   Custom Input and OutputFormat </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/15CustomInputandOutputFormat.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;   Hadoop 2.x and Yarn Introduction </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/16Hadoop2andYarnIntroduction.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Installing 2node hadoop 2 cluster on ubuntu </li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/17Installing2nodehadoop2clusteronubuntu.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  HDFS Federation</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/18HdfsFederation.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		     <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  High Availability and Zoo Keeper</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/19HAandZooKeeperIntroduction.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
           
             <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; Why  Hadoop Distributions</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/20HadoopDistributions-Why-Part1.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
           
             <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Hive-part1</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/21Hive-part1.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Hive-part2</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/22Hive-part2.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp;  Hive-part3</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/23Hive-Part3.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; PIG</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/24PIG.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		  
		    <li><i>+</i><span class="monitor-icon"></span>&nbsp;&nbsp; SQOOP</li>
           <p>
	           <span>
					 <a href="http://www.resources.way2learn.co.in/hadoop/videos/24Sqoop.exe"  >Video </a><br/>
					
			   </span>
		   </p>
		   
           
           
		   
               
      		
	</ul>
</div>
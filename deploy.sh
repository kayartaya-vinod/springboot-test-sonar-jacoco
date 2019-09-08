   service=springboottest
   if ps ax | grep -v grep | grep -v $0 | grep $service > /dev/null
   then
       service springboottest stop
       unlink /etc/init.d/springboottest
       chmod +x target/springboot-test.jar
       ln -s target/springboot-test.jar /etc/init.d/springboottest
       service springboottest start 
    else
       chmod +x  target/springboot-test.jar
       ln -s  target/springboot-test.jar /etc/init.d/springboottest
       service springboottest start 
    fi

   service=springboottest
   if ps ax | grep -v grep | grep -v $0 | grep $service > /dev/null
   then
       sudo service springboottest stop
       sudo unlink /etc/init.d/springboottest
       sudo chmod +x /target/springboot-test.jar
       sudo ln -s /target/springboot-test.jar /etc/init.d/springboottest
       sudo service springboottest start 
    else
       sudo chmod +x  /target/springboot-test.jar
       sudo ln -s  /target/springboot-test.jar /etc/init.d/springboottest
       sudo service springboottest start 
    fi

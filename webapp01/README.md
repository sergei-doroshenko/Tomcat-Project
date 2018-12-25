Build a Docker image:
`docker build -t webapp01 .`

Check built image:
`docker image ls`

Run built image: 
`docker run -it --rm -p 8888:8080 webapp01`

Launch an application on localhost: 
`http://localhost:8888/webapp01/message?name=Andrew`
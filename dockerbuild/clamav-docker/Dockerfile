FROM tomcat:7.0.93-jre8

EXPOSE 8080

RUN apt-get update && apt-get install -y build-essential
RUN apt-get install -y openssl libssl-dev libcurl4-openssl-dev zlib1g-dev libpng-dev libxml2-dev libjson-c-dev libbz2-dev libpcre3-dev ncurses-dev
# optional
#RUN apt-get install -y libmilter1.0.1 libmilter-dev
RUN apt-get install -y valgrind check

#ClamAV install
COPY clamav-0.101.2.tar.gz /usr/local
WORKDIR /usr/local
RUN tar xzf clamav-0.101.2.tar.gz
WORKDIR clamav-0.101.2
RUN ./configure --sysconfdir=/etc
RUN make -j2
RUN make check
RUN make install
#RUN su -c "make install"

COPY *.conf /etc/clamav/
COPY *.cvd /var/lib/clamav/

RUN freshclam

# Prerequitives:
# Donwnload ClamAV binaries: clamav-0.101.2.tar.gz
# Donwnload virus data bases: bytecode.cvd, daily.cvd, main.cvd

# docker build -t clamav01 .
# docker run -it --rm clamav01
# docker exec -it e7901fb1a2df bash

# /var/lib/clamav/main.cvd
FROM tomcat:7.0.93-jre8

EXPOSE 8080

#ClamAV install
RUN apt-get update && apt-get install -y  clamav-daemon clamav-freshclam

COPY *.conf /etc/clamav/
COPY *.cvd /var/lib/clamav/

RUN freshclam

# CMD ["/bin/bash", "-c", "freshclam"]

# Prerequitives:
# Donwnload ClamAV binaries: clamav-0.101.2.tar.gz
# Donwnload virus data bases: bytecode.cvd, daily.cvd, main.cvd

# docker build -t clamav01 .
# docker run -it --rm clamav01
# docker exec -it e7901fb1a2df bash

# /usr/share/doc/clamav-daemon/examples/clamd.conf.sample
# /etc/clamav/clamd.conf
# /etc/clamav/freshclam.conf
#
# cp /usr/share/doc/clamav-daemon/examples/clamd.conf.sample /etc/clamd.conf
# sed -i '/^Example/d' /etc/clamd.conf

#/var/lib/clamav/daily.cvd
#/var/lib/clamav/bytecode.cvd
#/var/lib/clamav/main.cvd

# /usr/sbin/clamd



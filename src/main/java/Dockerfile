LABEL Description="stoom desafio"

ARG admin_username
ENV admin_username ${admin_username:-"app"}

ARG admin_password
ENV admin_password ${admin_password:-"password"}

RUN printf "${admin_password}\n${admin_password}" | adduser ${admin_username} \
    && echo "${admin_username} ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

ADD deployments/*.jar /home/app/aplicacao.jar

USER app

WORKDIR /home/app/

CMD [ "java", "-Djavax.net.ssl.trustStore=/usr/local/jdk-11.0.3/lib/security/cacerts", "-jar", "aplicacao.jar" ]
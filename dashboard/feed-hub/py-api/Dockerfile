FROM tiangolo/uwsgi-nginx-flask:python3.6-alpine3.7

RUN apk update \
    && apk add --no-cache g++ gcc python3-dev musl-dev \
    && apk add --no-cache mariadb-dev

COPY ./requirements.txt /var/www/requirements.txt
RUN pip install -r /var/www/requirements.txt

COPY ./app /app
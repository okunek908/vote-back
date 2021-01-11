FROM postgres:13-alpine
# everything copied will be executed on container start
COPY init.sql /docker-entrypoint-initdb.d/
ENV POSTGRES_USER vote
ENV POSTGRES_PASSWORD gJnUwvJ&EbeP
ENV POSTGRES_DB vote
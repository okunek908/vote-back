## Cheat sheet
### To build Postgres image
`docker build -t mypostgres .`
### TO run Postgres image
`docker run -d -p5432:5432 mypostgres`
### To attach to running postgres container
`docker exec -it <container_hash> psql -U vote`

## Other 
### Image modifications:
You can modify created image by adding any sql scripts in init.sql before building the image.


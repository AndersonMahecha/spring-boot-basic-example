## Run mysql on docker
``docker run --name mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_ROOT_HOST=% -e MYSQL_DATABASE=productos -p 3306:3306 --rm mysql:5.7``
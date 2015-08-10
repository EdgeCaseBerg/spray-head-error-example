Example of possible bug in spray can
=======================================================================

To reproduce:

1. Clone this repo
2. `sbt`
3. `test` Note that both tests pass.
4. change `src/test/resources/test.conf` to be off instead of on for single setting
5. `reload` then `test` Note that both tests still pass
6. Ensure `src/main/resources/application.conf` has: `spray.can.server.transparent-head-requests="off"`
7. `run`
8. `curl -I http://localhost:9002/v0/healthcheck` <pre>curl -I localhost:9002/v0/healthcheck
HTTP/1.1 200 OK
Server: spray-can/1.3.3
Date: Mon, 10 Aug 2015 14:37:00 GMT
Content-Type: text/plain; charset=UTF-8
</pre>
9. kill the running process, and change `src/main/resources/application.conf` to `spray.can.server.transparent-head-requests="on"`
10. `sbt run`
11. `curl -I localhost:9002/v0/healthcheck` <pre>curl -I localhost:9002/v0/healthcheck
HTTP/1.1 404 Not Found
Server: spray-can/1.3.3
Date: Mon, 10 Aug 2015 14:39:37 GMT
Content-Type: text/plain; charset=UTF-8
Content-Length: 42
</pre>
# python3

import socket
import sys
import time
import threading

def run_server(port=53210):
  serv_sock = create_serv_sock(port)
  cid = 0
  while True:
    client_sock = accept_client_conn(serv_sock, cid)
    t = threading.Thread(target=serve_client,
                         args=(client_sock, cid))
    t.start()
    cid += 1

def serve_client(client_sock, cid):
  while True:
    request = read_request(client_sock)
    if request is None:
      print(f'Client #{cid} disconnected')
      break
    else:
      if 'exit' in request.decode('utf-8'):
        write_response_close(client_sock, cid)
        break
      response = handle_request(request)
      write_response(client_sock, response)

def create_serv_sock(serv_port):
  serv_sock = socket.socket(socket.AF_INET,
                            socket.SOCK_STREAM,
                            proto=0)
  serv_sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

  serv_sock.bind(('', serv_port))
  serv_sock.listen()
  return serv_sock

def accept_client_conn(serv_sock, cid):
  client_sock, client_addr = serv_sock.accept()
  print(f'Client #{cid} connected '
        f'{client_addr[0]}:{client_addr[1]}')
  return client_sock

def read_request(client_sock):
  request = bytearray()
  try:
    request = client_sock.recv(1024)
    if not request:
     #extraTask
      return None
    return request

  except ConnectionResetError:
    return None
  except:
    raise

def handle_request(request):
  return request[::-1]

def write_response(client_sock, response):
  client_sock.sendall(response)

def write_response_close(client_sock, cid):
  client_sock.close()
  print(f'Client #{cid} has been made')



if __name__ == '__main__':
  run_server(port=int(sys.argv[1]))


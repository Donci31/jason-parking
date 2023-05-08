+auction(ID, N)[source(S)] : not occupied(park_place2) & auction(ID, 3)
   <- .send(S, tell, place_bid(N, 1)).

+auction(ID, N)[source(S)] : not occupied(park_place2) & auction(ID, 4)
   <- .send(S, tell, place_bid(N, 1)).

+auction(ID, N)[source(S)] : occupied(park_place2)
   <- .send(S, tell, place_bid(N, 0)).

+auction(ID, N)[source(S)] : not auction(ID, 3) & not auction(ID, 4)
   <- .send(S, tell, place_bid(N, 0)).

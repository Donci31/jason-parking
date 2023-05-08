+auction(ID, N)[source(S)] : not occupied(park_place3) & auction(ID, 5)
   <- .send(S, tell, place_bid(N, 1)).

+auction(ID, N)[source(S)] : not occupied(park_place3) & auction(ID, 6)
   <- .send(S, tell, place_bid(N, 1)).

+auction(ID, N)[source(S)] : occupied(park_place3)
   <- .send(S, tell, place_bid(N, 0)).

+auction(ID, N)[source(S)] : not auction(ID, 5) & not auction(ID, 6)
   <- .send(S, tell, place_bid(N, 0)).

+auction(ID, EXIT)[source(S)] : not occupied(park_place3) & auction(ID, 5)
   <- .send(S, tell, place_bid(EXIT, 2)).

+auction(ID, EXIT)[source(S)] : not occupied(park_place3) & auction(ID, 6)
   <- .send(S, tell, place_bid(EXIT, 2)).

+auction(ID, EXIT)[source(S)] : not occupied(park_place3) & not auction(ID, 5) & not auction(ID, 6)
   <- .send(S, tell, place_bid(EXIT, 1)).

+auction(ID, EXIT)[source(S)] : occupied(park_place3)
   <- .send(S, tell, place_bid(EXIT, 0)).

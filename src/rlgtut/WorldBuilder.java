package rlgtut;

public class WorldBuilder {
    private int heigth, width;
    private Tile[][] tiles;

    public WorldBuilder(int width, int heigth){
        this.heigth = heigth;
        this.width = width;
        this.tiles = new Tile[width][heigth];
    }
    public World build(){
        return new World(tiles);
    }
    /*
    private WorldBuilder randomizeTile(){
        for(int x = 0; x < width; x++){
            for (int y = 0; y < heigth; y++){
                tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }

     */
    private WorldBuilder randomizeTile(){
        double random;
        for(int x = 0; x < width; x++) {
            for (int y = 0; y < heigth; y++) {
               random = Math.random();
               if(random < 0.4){tiles[x][y] = Tile.FLOOR;continue;}
               if(random < 0.7){tiles[x][y] = Tile.TREE;continue;}
               if(random < 1){tiles[x][y] = Tile.WALL;continue;}
            }
        }
        return this;
    }
    //smooth start
    private WorldBuilder smooth(int times) {
        Tile[][] tiles2 = new Tile[width][heigth];
        for(int time = 0; time < times; time++){
            for(int x = 0; x < width; x++){
                for (int y = 0; y < heigth; y++){
                    int floors = 0;
                    int rocks = 0;
                    int trees = 0;

                    for(int ox = -1; ox < 2; ox++) {
                        for (int oy = -1; oy < 2; oy++) {
                            if (x + ox < 0 || x + ox >= width || y + oy < 0 || y + oy >= heigth) {
                                continue;
                            }
                            switch (tiles[x + ox][y + oy]){
                                case FLOOR: floors++;break;
                                case WALL: rocks++;break;
                                case TREE: trees++;break;
                            }
                            /*
                            if (tiles[x + ox][y + oy] == Tile.FLOOR) {
                                floors++;
                            }else {
                                rocks++;
                            }

                             */
                        }
                    }

                    tiles2[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                    if(tiles2[x][y] == Tile.FLOOR){
                        tiles2[x][y] = floors>=trees ? Tile.FLOOR : Tile.TREE;
                    }else {
                        tiles2[x][y] = rocks>trees ? Tile.WALL : Tile.TREE;
                    }

                }

            }
            tiles = tiles2;
        }
        return this;
    }
    //smooth end

    public WorldBuilder makeCaves(){
        return randomizeTile().smooth(8);
    }
}

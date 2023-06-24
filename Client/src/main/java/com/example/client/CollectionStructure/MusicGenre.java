package com.example.client.CollectionStructure;

import java.util.HashMap;

public enum MusicGenre {
    ROCK{
        @Override
        public String toString() {
            return "Rock";
        }
    },
    PROGRESSIVE_ROCK{
        @Override
        public String toString() {
            return "Progressive rock";
        }
    },
    POST_PUNK{
        @Override
        public String toString() {
            return "Post punk";
        }
    },
    POST_ROCK{
        @Override
        public String toString() {
            return "Post rock";
        }
    },
    PUNK_ROCK{
        @Override
        public String toString() {
            return "Punk rock";
        }
    };
    public static MusicGenre getGenreName(String name){
        HashMap<String, MusicGenre> genres = new HashMap<>();
        genres.put("rock", MusicGenre.ROCK);
        genres.put("progressive rock", MusicGenre.PROGRESSIVE_ROCK);
        genres.put("post punk", MusicGenre.POST_PUNK);
        genres.put("post rock", MusicGenre.POST_ROCK);
        genres.put("punk rock", MusicGenre.PUNK_ROCK);
        return genres.get(name);
    }
    public static MusicGenre getById(String name){
        HashMap<String, MusicGenre> genres = new HashMap<>();
        genres.put("1", MusicGenre.ROCK);
        genres.put("2", MusicGenre.PROGRESSIVE_ROCK);
        genres.put("3", MusicGenre.POST_PUNK);
        genres.put("4", MusicGenre.POST_ROCK);
        genres.put("5", MusicGenre.PUNK_ROCK);
        return genres.get(name);
    }
}

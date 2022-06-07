package com.viskei.alpha.model;

import java.util.Objects;

public class Gif {

    private Data data;

    public Gif() {
    }

    public Gif(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Gif{" +
                "data=" + data +
                '}';
    }

    public class Data {
        private String id;
        private String title;
        private String embed_url;

        public Data() {
        }

        public Data(String id, String title, String embed_url) {
            this.id = id;
            this.title = title;
            this.embed_url = embed_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEmbed_url() {
            return embed_url;
        }

        public void setEmbed_url(String embed_url) {
            this.embed_url = embed_url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return Objects.equals(id, data.id) && Objects.equals(title, data.title) && Objects.equals(embed_url, data.embed_url);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, title, embed_url);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", embed_url='" + embed_url + '\'' +
                    '}';
        }
    }
}

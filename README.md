# YouTube Music Video Popularity Analysis

> **NYU CSCI-GA.2436 — Realtime and Big Data Analytics | Spring 2026 | Group 30**

## Overview

This project analyzes the factors that influence YouTube music video popularity and longevity using large-scale distributed data processing. By combining video engagement data, song metadata, and lyrical content, we aim to uncover patterns that drive whether a music video trends — and how long it stays relevant.

## Research Questions

- What factors determine whether a music video trends on YouTube?
- How do engagement metrics (views, likes, comments) relate to a video's sustained popularity?
- Do audio features (genre, tempo, energy) and lyrical sentiment affect trending success?
- At what point can popularity be predicted from early engagement signals?

## Datasets

| Dataset | Source | Owner | Description |
|---|---|---|---|
| YouTube Trending | Kaggle | Claire Chen | Video-level engagement data: views, likes, comments, trending dates |
| Spotify Tracks | Kaggle | Anusha C | Song metadata: artist, genre, audio features (tempo, energy, valence, etc.) |
| Lyrics (Genius) | Kaggle | Wilson Lu | Song lyrics for sentiment analysis and text feature extraction |

## Architecture & Pipeline

```
Raw Data (Kaggle)
      │
      ▼
HDFS (distributed storage)
      │
      ▼
MapReduce (data profiling & cleaning)
  ├── Profile each column (missing values, distributions, format issues)
  └── Clean: normalize names, remove duplicates, standardize formats
      │
      ▼
Hive (data integration)
  └── Join datasets on artist name + song title
      │
      ▼
Analysis & Insights
  ├── Trending duration analysis
  ├── Engagement vs. longevity correlation
  ├── Genre & audio feature impact
  └── Lyrical sentiment vs. popularity
```

## Technologies

- **HDFS** — Distributed storage for all datasets
- **MapReduce** — Data profiling and cleaning (Java/Python)
- **Hive** — Data integration and analytical queries

## Project Structure

```
├── youtube/          # Claire: YouTube dataset profiling & cleaning
│   ├── profiling/
│   ├── cleaning/
│   └── report/
├── spotify/          # Anusha: Spotify dataset profiling & cleaning
│   ├── profiling/
│   ├── cleaning/
│   └── report/
├── lyrics/           # Wilson: Lyrics dataset profiling, cleaning & sentiment
│   ├── profiling/
│   ├── cleaning/
│   └── report/
├── integration/      # Shared: Hive join queries and analysis
└── presentation/     # Team presentation slides
```

## Team

| Member | Dataset | Responsibilities |
|---|---|---|
| Claire Chen | YouTube Trending | Video engagement data: profiling, cleaning, trending analysis |
| Anusha C | Spotify Tracks | Song/artist metadata: audio features, genre analysis |
| Wilson Lu | Lyrics (Genius) | Lyrics text: cleaning, sentiment analysis (MapReduce) |


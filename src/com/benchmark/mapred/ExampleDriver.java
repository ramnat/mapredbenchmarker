/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.benchmark.mapred;

import com.benchmark.mapred.dancing.DistributedPentomino;
import com.benchmark.mapred.dancing.Sudoku;
import com.benchmark.mapred.Classification;
import com.benchmark.mapred.kmeans.Kmeans;
import com.benchmark.mapred.HistogramMovies;
import com.benchmark.mapred.HistogramRatings;
import com.benchmark.mapred.SelfJoin;
import com.benchmark.mapred.SequenceCount;
import com.benchmark.mapred.RankedInvertedIndex;
import com.benchmark.mapred.AdjList;
import com.benchmark.mapred.InvertedIndex;
import com.benchmark.mapred.TermVectorPerHost;
import com.benchmark.mapred.terasort.TeraGen;
import com.benchmark.mapred.terasort.TeraSort;
import com.benchmark.mapred.terasort.TeraValidate;
import org.apache.hadoop.util.ProgramDriver;

/**
 * A description of an example program based on its class and a 
 * human-readable description.
 */
public class ExampleDriver {

  public static void main(String argv[]){
    int exitCode = -1;

    ProgramDriver pgd = new ProgramDriver();
    try {
      pgd.addClass("wordcount", WordCount.class, 
      "A map/reduce program that counts the words in the input files.");
      pgd.addClass("aggregatewordcount", AggregateWordCount.class, 
      "An Aggregate based map/reduce program that counts the words in the input files.");
      pgd.addClass("aggregatewordhist", AggregateWordHistogram.class, 
      "An Aggregate based map/reduce program that computes the histogram of the words in the input files.");
      pgd.addClass("grep", Grep.class, 
      "A map/reduce program that counts the matches of a regex in the input.");
      pgd.addClass("randomwriter", RandomWriter.class, 
      "A map/reduce program that writes 10GB of random data per node.");
      pgd.addClass("randomtextwriter", RandomTextWriter.class, 
      "A map/reduce program that writes 10GB of random textual data per node.");
      pgd.addClass("sort", Sort.class, "A map/reduce program that sorts the data written by the random writer.");
      pgd.addClass("pi", PiEstimator.class, "A map/reduce program that estimates Pi using monte-carlo method.");
      pgd.addClass("pentomino", DistributedPentomino.class,
      "A map/reduce tile laying program to find solutions to pentomino problems.");
      pgd.addClass("secondarysort", SecondarySort.class,
      "An example defining a secondary sort to the reduce.");
      pgd.addClass("sudoku", Sudoku.class, "A sudoku solver.");
      pgd.addClass("sleep", SleepJob.class, "A job that sleeps at each map and reduce task.");
      pgd.addClass("join", Join.class, "A job that effects a join over sorted, equally partitioned datasets");
      pgd.addClass("multifilewc", MultiFileWordCount.class, "A job that counts words from several files.");
      pgd.addClass("dbcount", DBCountPageView.class, "An example job that count the pageview counts from a database.");
      pgd.addClass("teragen", TeraGen.class, "Generate data for the terasort");
      pgd.addClass("terasort", TeraSort.class, "Run the terasort");
      pgd.addClass("teravalidate", TeraValidate.class, "Checking results of terasort");
      pgd.addClass("kmeans", Kmeans.class, "Kmeans on movies data");
      pgd.addClass("classification", Classification.class, "Classify movies into clusters");
      pgd.addClass("histogram_movies", HistogramMovies.class,
      "A map/reduce program that gives a histogram of movies based on ratings.");
      pgd.addClass("histogram_ratings", HistogramRatings.class,
      "A map/reduce program that gives a histogram of users ratings on movies.");
      pgd.addClass("selfjoin", SelfJoin.class,
      "A map/reduce program that creates k+1 associations given set of k-field associations");
      pgd.addClass("invertedindex", InvertedIndex.class,
      "A map/reduce program that creates an inverted index of documents.");
      pgd.addClass("adjlist", AdjList.class,
      "A map/reduce program that finds adjacency list of graph nodes.");
      pgd.addClass("termvectorperhost", TermVectorPerHost.class,
      "A map/reduce program that creates the term-vectors (frequency of words) per document.");
      pgd.addClass("sequencecount", SequenceCount.class,
      "A map/reduce program that counts the occurrence of consecutive words in the input files.");
      pgd.addClass("rankedinvertedindex", RankedInvertedIndex.class,
      "A map/reduce program that creates the top k document lists per word");


      pgd.driver(argv);

      // Success
      exitCode = 0;
    }
    catch(Throwable e){
      e.printStackTrace();
    }

    System.exit(exitCode);
  }
}

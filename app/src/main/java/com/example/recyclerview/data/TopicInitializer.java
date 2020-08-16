package com.example.recyclerview.data;

import android.content.Context;

import java.util.ArrayList;

public class TopicInitializer implements DataInitializable {
    @Override
    public void runInitialization(Context context) {
        ArrayList<Topic> topics = new ArrayList<>();
        topics.addAll(createBasicEnglishCourseTopics(context));
        topics.addAll(createChildrenEnglishCourseTopics(context));
        topics.addAll(createHighSchoolEnglishCourseTopics(context));
        topics.addAll(createOfficeEnglishCourseTopics(context));
        topics.addAll(createProgrammingEnglishCourseTopics(context));
        topics.addAll(createTravelEnglishCourseTopics(context));
        topics.addAll(createIeltsCourseTopics(context));
        topics.addAll(createToeicCourseTopics(context));
        TopicDAO topicDAO = new TopicDAO(new DatabaseHelper(context));
        topicDAO.addTopics(topics);
    }

    ArrayList<Topic> createBasicEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.BASIC_ENGLISH);
        int courseId = course.getId();

        ArrayList<Topic> arrayListBasicEnglish = new ArrayList<>();
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.ANIMAL, "/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxIQDxAQEBIVFhUWFxcVFhgVFxUYFRUXFxcYGhYXGBgYHSggGBonGxYYITEhJSkrLi4uGB8zODMsNygtLisBCgoKDg0OGxAQGy0fHyUvLS0tLS0tLS0tLS0tKy0tLS0tLS0tLS0tLS8tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIALoBEAMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAACAAEDBQYEBwj/xABBEAACAQMDAQYEAwUGBQQDAAABAhEAAyEEEjFBBRMiUWFxBjKBkUKhsRQjwdHwBzNSguHxYnKSorIVJHPCNEPi/8QAGQEAAwEBAQAAAAAAAAAAAAAAAAECAwQF/8QAJREAAgICAgIDAAIDAAAAAAAAAAECEQMhEjEiQQQTUXGBIzJC/9oADAMBAAIRAxEAPwD1aKJVqUW6NLddTkciiRi3S210BaRSp5FcTmiltqYpTbaLFRDtpwKkK0gtOwoELRBaILRhalspIjC0+2pNtKKVjoDbSipIpRRYURRS21JFICiwojiguXUVSzMoUckkAD3JwOaI6m2LgtF13wWCyNxAiSB1AkfeshqLVm1Z1Gj7sFLrC9Hh2EXOhk/MXtz/AJgaynmUTWGJyNgBThah7M1C3LVplxKKdpKyMcHaSPsSK6wtWpWrIcadEe2n21KBSiiwoi20oqSKaKLCiPbS21LtpbaLFRFtpFal20xFOwoi204SiiiAosKBCU+yjFPSsriRNbqPu66TQkU0xOIwWninFOKQ0hopRRRSpWOgNtLZRgUVFhRAbdNtroihK0+QnEiC0YWiinilY0httLbRUqQ6AihIqQ0JppiaBininAqi0eovpr7lq7dFy1dDm0uwK1k29soWB/eBg5M4jZHWaAoP4m7JW7b74N3dy0GZHzAAywaCJUhfPoD0rI6N3vG6+r1Fm4oMoqKqtbUA4uEPJA6iPw/b0TXpNm4BM7WiOZgxFef9iaO5f1bLvC2zb7xCVLF5+UsN8EENMAATtH4a5cy2q9nThev4NR2CLe91AXeoAwu0mBDSOsHjkRMHJq8iqPS9j37WoVw9tkxuwQ3rtGQOo561fRWmK0qaozyU3aGilFFFKtTMGKUUVPFFgDFKKKlSAGKaKKlQAEUooqVMKBinpUqAGNMaRpiaaExxRCmFOKGA9KlSpDHpUwp6AFSpUqAFSpGmoAelTU80AMaGaImgpoCt7Z7Yt2Ctu4rE3A0Hu7r28RhiitBM4XkwarfhzQuWF1gQoDIguB1vC221iSs+GSgADANtAmDitGl0EwGE+QImpKQCInFea/CGpU620EW4gl12YFtWtjY+JwD3qwuD+6nIzXpUxk15j2NA1id9e71u+3WfBthiBhmiLm23dAB8iw5Bjk+RLjKJ0YY3GR6hSpUq6jnFSpUqAFSpU9IY1KlSoAVKlSpgKKanpUADFMaKmNMQBoKNqCqRLDBp5oAaIGkwTCmlQ0poGFT0BNINSoLCJpt1MTTU6Cwpp5oa4O3e1F0th7zRjCg9WPA/Ik+gNJ0hrbo7b2oRBLsq/wDMQP1rmftayAT3g/OvBO3e2Lty41533MTPlHkBHpGOkVBpO3rxk940AHDE4gjJE+0ffyrD7b6On6K7PddT24hBWy3j4B2khc5wYk+nnFV767f4A1xiZEwYHvWQ+HL7Lats58VzxSZHIMCPp+XStTY1O0AmBmPT7z5ispZW3RSxKJ12Ldy3BHI43EAH0kTH2rqPbLCdygEcjJP61FeYABuh/Ijp/XlVT2ldDOiINxYcDznqRwOaXJxWmLipdlhrviNlXwhJbwjcDBY8DB86zHZFu1Z1Fkm614d83dednvWDuLn2ZlJ43EeVVXxBbe3ctm64Ch1JIkgKCCxJx0qx0HeWmm7jUXkVnUjwfuG23LixjcbbjHofpyZMrlJWzphjUYuvZ6el0NkGjBrO9idpo6jx5jg4+lXyNIr1Mc+SPOnFxZJNPQA04NWSHT0E080DHpUqVACpTTTTGgB5pUM0t1AgqY000xNADNQxRUxp2SDTg0NPTsQU0xpqVAwTTzTmmFOxUEKKmFFU2Uhq8/8A7QO0g91dOJOzkDb8zAcg+QP5mvQa8Z+Ib3ePeuc72ZomBBYwT5iBx+lYZ5VGv06fjwuV/hmtVp+8J2gkCeM8dK5dHoN95QflUEsDHiWR4PXIH0BrQXLg2pbA/wCY+vp9TVF2xaZSbiHJ2qMxAyD+tc8EdeR6NrZurc1NkK3htgsR5kjw/wAfvWktwE9P415/8NKTqEk8q4z6JI/2FbrREskADlhjjw3GHXnApNbM2y37N1HhCt8vOen9fwoLqDvxH4Z/7lb+Ij6VDbjuyQ/dj/FiQNwkT5xI+tcr6w95EnADTxumQD74M+4ol/qQuyh7fh762nWULBTIkFWIXafctt+tTdmWLpUu575WYXtNcmfBdQrsI6FUIM5Bjoah1t/vS790b3d7T3a/M7B1KnkYUruPsKi+G9Kum2X7A723f2HcXb/2+m271m2R4Y8Q8vCOvPC+zs/5LDsTXDC43DDAhgwHnB5FbXsTVEjaTIOVP9frWEvaYd8cA78AjzGQykdCJkevkc6TsB3YgKMj5yIHs56GfT1ruwSpnJmimjXTSmhpV6BwhTRA1HTg0ASzSmg3Ui1IY5NNNDNKmIeaemp6AFSp6akMVNSNKmICaU1GHpi9BJITTBqj3U4NABzRioxRCgZIKcUANEDSKCIryb4s7HbS3IMlGcd2xzPXPmwGI/hXrE1Bq9Ot1GRwCp9seRE8EHINZ5IKSNceRwdniWvJUbRznPn5n7n86ou2mBtVu/i/sJtLtM70JMNERAMKegPrOY9MYrU6cliriVLbT7SP4LXOo0zsclJWi5+E0O91bnbJgjLFdjAyCOWOf6G37PuYGSZhsgf/ALNz9IgyT1MVi/h5z3lwzGJMdIuWySZBiGC5BwCTyJrZaMlE/HEEAN4hILLktJJEGfeqktmNljf0+7TMAYI2sPKQR5/rWa7Yv+B7o4YwvlAEA+xiftWg3d4GsknbdRkJB805B5Bg+/HWs18SEMyopCCJM8IoUsQR1OCI96yy9FY+yqNuLW7e9i4blsWroMoHKEot2MhSWjgz+VW+p0vd6u7rr19CltLi3EtqN4sqoUWnHO4m7uZiYXw/4iahtaFytnxobAZhd76O4C27m5QmQ5ugpCnmNzE5Aru0mi26pjcKu19tYbNrN61eRl07qzOMW1VrSr4hyYHQnlStnXKVI7nsG+lprds7mVHUEyxDAZLH2Hi84Narsjs/uQ0mWYyfIeg88zn1rL6UajT23uam5+8Z3LFQQyrAIRejIAEAj9SRVzodZd4J3eckH+Ndvx679nDmvpdF/SrntaieRUpujzrrs5uIdNQ94PMUwuDzFFioOaU0O6ucawd61vyUGTiSTwDwaOSDizrBp6AUQNOxBCnoaegYU0ppqVIBUqVMaYHHNPNDT1Nk0EKcUIp5osdEgNEDUYNEDRY6DmnmgmlNLkOgy1NNDSmlyHRk/wC1MH/0u8ysVZWRlI5DTC845IGcZrzLsWdcdP3Y/eXWbcCfCD4t8QOBDtnptr1z44s7+z9QvovUD8Q6nj3ry/4A19rR29dfcqWtL+4tz4na6uYHIUBQCem9vrD3s2xukc3Y3984uwHD7WBBYA+PvAYBEgoBJ55rZ6BBBC+e2QroRCp12gDqfpPt552FriLm57ltSXJY3MBi4G7BdQfnYx0gV6B2MN1u23hICgYBwRAIJ3tJndkEzE5BqJM0om0mtRtdY0hYhriXTIMEMAm0481kiOdpqkXtJL5uHuSzq5tujZKso8e0K3jiMDr1Akxn11Tt2je1SsQbVyLZwcrPPmMMD5y3WtBoL4Ny49xlRLtzvigMKzli4UdZyT7AyCJFZZaorH2LtFNouOdINS9rdeUCO5LPcNtkUJuBbbaW5BJMu85GJdFeNnT2lu6c6YajU2w9tGC23W7bWRDqWRdyw6pHyFiQDmDXW7KLprupuXxbt6h7gF5CqXGQ2SO7NkwTuJZQVhpu4EAgbeg1Nq7es2tUtu9cJKFQR3g2qBbO6Tb8TMQwB/DnpWFG9/pdaXV377bb7WhcDWmS1EtpVZXOVPDlVuIIMDwHrVn2brTMFNsAbo+UEgYGTNZ79kAfV3ksPbt3Xg3mtfNeR7bLda28HaWIS2vG4uzbpleTSdubrjkYUHAK/N0Un6AVrh0ZT2elafUDqD/XvXbaYN/qM1hbHbcKTgnzGM/au/Q9tShaDXUpnO8bNTecLha5GEgmc1T2O1pJLEgdBBrrtdogjJB9OtPkmLg0LW6zu/FOcfUH06mq7/1DcT1Jj1ou1GDLIPvnoPTpVWui3QUfM9emai2aKKo7u1O1m0qG+LiSmSD+IFlwxjgDccHn8rD4I+Mk7TF3bbKG3tJzuVgxYAgwOqHHtWO+L+yje0zWyfAzDxAgExI8jWl/s/0tjS2xZsoFkeI5LNHEznqxjgSeJq4sicVRtaehpVdmAdKaGaVFgPSpppUWBx09RK49T6x/Hijms+Q6DmluoAaU0mx0SA0QqNWpXboRSzGABJJ4AFFhRMDTXLoUSxAHrWK1/wDaLp7d0IEciD4j4VkdM8eZ8vLy5LPb51JJ3AyJLCCFEgQonA9KZfBm1bteyDG4/RLh/Ragv9uW1ZQJYHlhiPSDBJrKuxIKZ5BjALAA8wPPbUJKv8zkD5YWJke2Bj60BxNdqrqavSXhZYNKkCOdy5CkHgyB96+bte72tWjthdxVp4j5WJ6QMHNevaPtazoLqv3rlXJVgYCmDjETI8/51kviWzYPaDajTsn7Pch7nGJP7xSJ5MGI4nzGDplRRmOztYyX3AzkSNm4bSPKD5Dp9ua9Z+G3LIu/b9FPBO4/NaU/l0HtXj+h0pTUKjDgAAETMAgYGZx0INeodlsV0l66SfBauNMXAIVGPVznH396iZaMTY1YZGA+a47uYOfEeTOfxbft61qrOsC2g6bVeV7udpAc7gp8XsTMcDFef9g3N9zcQcYxAGM5n2H5Vd/FOsuWLek2mH3G9OYm3AUEdV8bgjrUZI2+JcJUrNVa1lu4LUWVRi57vYumeXuW973bb3CVtgdwwIIMlVz1Pfp+0J7UwZG02pCz4iVO/cGwNwI2z156VSalxc0JuWmRVe33r99MFLwc3E7wHcuWGRAGYEYM3wHqDfu9oXLhLravsoMSdobnAySBPqa4/Km/w6J1pHf29qe4slrN7vlCdyGF1XVGF62WU2ris26CQCWYjZyCZrMpeVFUEmBg4nxHgfkaL4i1odkuXLgvOLl1FugD+7Rie7MADcrnMSICQSGrl7GvW9S9y3cc7ApwsKZZgVZTDCQQeeh611YI+JhkdM7BrNqswnYIVm24BbgT/XI8669L2gVjxY49znzqHt5FsaWyloGHw4Mk79yXGbjHyBQJOPbOeTXb7nMAYGPTJ/OPvW/EhM3mn7VXjH61Yr2mhECJ9Kw1m6VHysV89rAe+aSaogyTA+1TQzZai8jHbg5jFV2svtagbuhPtE9foaz6ayDuDRH29zUWo13eLMy27PPiUfKF6fNJI6wkSRRxK5aLo9qPc2oQOZU+UCD9fyzWr7Fs7AjzmQTPrnpXnVnUh1EEz0j5t3kOszitP2fqNhtyxkL4kUyA0nw7h54MDgmOlHQntHq1m9uE0Vu8rSFIMcweK8403xeTCvbK7gQQWJ2x1kgfb1qz0Papslrm7cbgCjeAAILEYUz1j/eqlOmZLC2rNnevhFLsYAEmuXsPUm5p7btyd3P/ADMB+Vef67tjU629a0/DucIm7YgBzcfzgZn0xmvRtLZW0iW14VQo84Aj+FJTsmePit9nRNKaGaYtVcjOiut3F2jbtHtBAJz05p7jkCeesDmPbqaqLnaBA9OZ9MR/Xp9w/bl/vATPvG6ZAieev2Fcn3x/Tb62XDXIWTjgyMTgZ/0zRJcaJ5zzPSeenSqgawyFInnPMRGT9ef9K6rerAgDjr6T/qaX3If1std1Yf4g+IS+tXS2mVkI23JBZfDvJBI4MiCeh2gxIrR39bCFonBPPUcCa8w+AdULhv3b34vGk9RcInHl4APrVSl4svFDyI27G/br1sotpmt3CGLbWWQAdrTziegz0kY7u0LFzSEuUVBiTbgoYjpGMcVoOy9QpUXrVklXYWXVe73bt2xZG4QC0j/OCYEmqf4yvd4NQni8GIwF8GREHgww+3WiPLV9Fyq3RX9s9rO6wihoSWLcCSc8gkwDUHYF9rTBrlpAcsABBYEk5kSBJwB0U1VafVWirFoLqe7gjoAFAHQAkT9qru0+3yjoltY5PlG9YAn+PmB5V1pHM3RL8W9pl0KsDuncDyBOCODPM1HrC9y0dPdNkAKCjCzbVgFPhC3FG4jpBJEE4xig7Q7SuXz+8JJEZJM4mBzxk49T516f/ZGCNNqNwkG4InPKCR+n3pZJcI2KO2Zrtsm5e0N4hdz2wjQBslSpEDcAJF3zHH0rWFwnZutO2CdPdH4CP7tgMqPWIJrLdq6I217onNjWbRJytplhPXMKc+daC9B7L1mZBtwfQEqJge/P8qzu0jb9Mr8M6YQCIOJPlGMnrWi+N+yVPZ1jUbgLisQFPLqT4o84In7+lcnYeiKFFMTP/wBipmfb145q5+K9B3mltuD4rC5UxtZDBb6jJn6eRrNyrJsqvGik+E9c13s7UWgCWRXtDJA2srsklfFEllj7Zk1p/gbsO7p9Jr9U5UDUOb1oGGASH2M23wgEkH2HSaw3wmuwah4BWEkEZLB12R7eI/SvRbPaa2+yVBh3Cw5MKAgcAMIA/DaYgjEgelYZWoymv02ScoxZkviDsu9efTqm1bO5dN3kfu1cOttiYYxkAgEzGOhhfDnYo0/fFmYM129ZAlYK2GVCWG2Q253Aho5GYrQ6fUm5p0BUOxuXCqkRbd1u2mtE7ZA/fPZ3En5O9PANcnxEQujm2ZZ1KKzDaz2wt29ce5geJgL7sCBDsRzmuv4y/wAaOXM/No4/jkMmkssmQjDfniUKgkRI8TczHijmsl2XYKWhvBVjJIyrZJImcjmfrXoHwxfvaexau3FKlBdYAzuI+e4Np4ELvLEADYiyS520n9oLx2hd5zsMnqAirP3Uj6Vo2KLKwwOre+5p/M1Q3e0bm5oaQJjdkx+taD9h7zs/V6ktCosJ0LMWQE+wDR6k+lRfC/wWb9vfeLgchVKgkDJmQYMQfr6Gp5xS2XTb0aj+zf4Tt6uy17WM/wA3gthgoZYHjPWCZAiOJ8q3174T0PdqlrTaeUII3IHkdRcJlmEeZ5isr2YLdnTtcDhFQqLkFQCUAVVLN5hVHQyROSa1PY+st87vHcUNkqWVMsFLLggbjB/M1g8vt6Q3BvozOu7AS6GSzaVLqXmUMiqGAeC6FsboHFxpIECsl2lqxZd7CK6EQpW5O7dGTBzBPGfX0Hovw/dFy/fuAtDXLh5wZgKdvmFAH1qw7b7M0+qUjUIpK/K3FxYyQGGY9ODUwyr2ypWnR5F2dbBfdcJn14+s9K0waAqhxuB+VtxDezAEgjB+1T9o/A+3Y+nukwwlLhEkT4oYQJjoQOeaHsj4a1TuGdrqoeVuvbKgZ+UWySDPrEda1eSDV2JWjafCfZKWbIujNy4AzsYmDkIPIcf1FXqHJxx/rkHr5feuHSqqIlpRCqAoHkBAFSrdxzMYz1gc1CyIzkm3Z0K2cfWTxxRo3nXOtwcxB/nSa/j6fnT+xE8WY1LgyTAIkefHH+/lQftfzY8Ung4EEwCR9f65qdPqC0jdJxk88t6dQD9+kVW/EHa50ti7cttLIU6+ZEwcxyfaOOa8qEJSkonbKoptmutaosMQP+KcGDkR54qRNQTba5KwhWTIklmML6n09axPwz8SjUko4d3JOCRIIEkLkSoAPPXgxFQdrWl1tu/Yt3Nt63eS+FPy3AFZAJ9t0TwT5Zruh8Ly83oxeXWkbS1YtANcO4k3HDBDmGXyk8Zx7HpXlNvU3Ozr7WX8RtwoIwLlo/K49NhGOhUjkUPw52wFcJee7buL4eCVbzR0bjieh48q4/ivUH9pFwQQV6cRksAP8xP1ruljd09p9f0YrJ7XZo9BrN1wG3Y014Nc3r31oO9slRIXIxIBg/xrl7Q1LEsUPh2sz9ZDDbuMcHczfcedVnYfbC2VZWWQcBhyhxtIPuceWavvhrT7Ge4SDv4kfiPP8voKydwTb6XRrak9e+zK95N3qAR4sckRB/ryoL+jDXDcuOAp+XzJWBgfSpH7Pdbl0HIVWYEzBCuBI9eSR0rV/C2ks39Ibd20pYOQxMhwSZWGBBiCABxWk8igrMlDk6MBqLWxvmB9q9j/ALPfBoLOM3C1z3k+H/tC1jPiPsOzZuW+5SAyKvmJLMCxkmT7nofKt92fdCKqIAFUAAYAAUQB+Vc3ycylBV7NMeOm7KX4w0m29dcxF0WWzg7rbqhH2ZT6zHSg1GoKdn6jYm/+6G0nBXvlBzzx1HHMU/xc7M6sDjag8zuFwMPbjOR0odQ5/YQsDNxFXAM7Sbh68wp4kjpNGJ+KbHJdo6OwQGZGSSEaRMhkBEFWBwNsGOZCgcRU3xFeufs7tbAng/8AKZBMcesmuTsEEB93WSCeSIkSTzjqcmuzUX/DjmB9cmPpGPpXPlyeaa9GsYaMbY0dzZd2XTbI8YAAKmPmVpHHrmJHNaVNGx0AVbh8IYcKUDKxuMQCIyZGeNoiOs+m0yWmu3FEAId3USGUiPLj9Kk0uwadY+Qqre5bBk5x7T9ajJl5bRvCFJHJobZOkRLjlmKli0bDvurftthTGLbnP/ADXV3m9IzuN++6lAC9u4NXqCrKDh12vcRrcTtYxOKfVaYLaZedqsOTxBHkTMMR55I9RXdm23uct8x3YONzEs5xEyWLTyCW4DRXfgzcoHBlhUjS6XTac2SguB1gLdt2iT3dsc2peBYVog7isLuAydww/wAfXmv6pFABdlYuFyqzdcwGIHhG4wSBiPOrDRrfQublxixMAAt8wAwd3kF8uuDxElvs194J8TOTkEekDnwwvT196uWVJaCGNt7LPsLRhbFm2VBCRgDcGYeInMCcx15PMRVlr7gDMEMMcMD82N20QSI+Vog8qTu5NLS3CBDeYkA+IA+OAcBTInxAiSwMLkVGv1Nu5ecBgSuPBtCk+LC7g3kfDBAKx4tueVLs29kvaNy5prAu2IBe4lstDYyI5GBLAcf4sCZqj1fbFy2FSR4gd/JJM+Zz1q70q77RtMFIDlisMGO0goxVgCJ2z15nrXH2nbtd4sIv4TIHilgZ9DkfeD5VjJpun6OnG6RYdl9o3bNm0EALOzyOSQIMjyHGa673a+pOFEzHOcGI+v6VW6fUl9zEgADZ4cQJ3RHTkZqs1HatxLw2iTuAHlnGfp+nrRB+qTInBPZqdN2lfJM5gnOYhfmIn1rs0nbL+IFAp/DLMRcEAgAxM/NgcQeKz2g7VOxT5hh9SetaDSMHGnkLtUqSIEzInPTzP1FaKcW9pGUsddGkW/IUjgifv0o0v5iJ8h19az/bnbI0upW0wAVl32zmHGNwHQEHHXDKeoqaz2or/IwbyjPX29al4cq9aMlOJdNfg8g9fQZoe8x6zXItwZ+se+OMY5obt8ERI+k8DkCueWRJ9lpHnf7bs8SeIgmT6kEdcYBj+jVVc7SVg2/IYMGmPkhT9Zj7Gov2goGAUzPXLentJJH3rj1dgOd36QScxn3gZ84HNdEcaT2aORxkFLiBBtIgHbI8KzHrkIpq97FtZ1F58PuCnjwooM84j5R9fXFfpLJALPjgwMxmGA9IIE5jZViNQFZVPkZA6/NPHT1rfLkb0jOEP05u2+zQ9vvV2s6tbMwA5V7bQJ6wUMA+XSuTsHSLq1/Z7uCYKNHHlH2Mj0q5tahu7dciWtHHkq3QPt3gFcdhtro6yPF4vQk9PMx09R50/tfGgWNJ2do+EgtttPuJ/fKGJABEpuAn6j0z7V2drsEe3aCyiJgjqZwMdTH51ZLqy5aSCVCmYO0bSoGR7+1UvazbnYEwDPUiQpEMB7/r1rKU+XZoo0V9tjccqRBuAqZx84iPSYAmu/sGyyW3aAfFB5jAAGOFH865NEZYCBBKAFhLdCD19TVjdvC3DTIYDicRiD6QePQ0pzbVCUd2Ltqyn/t2Zh4X8cEHwFgWLeUGKs+173dkNbIIJyFIEYBmOmDPWs46i7uDEwZ2wM8At1zwPvTXbzblIgEQW5+XOCfKcD2HoBPG0l+DumxdodoEv3YBG5VifVhWqXQE6YJ5sB7mOBH1z/OsVZHe37cGF3hhAkEqw/CvAwBxMec1daztPvWYmAoIC7ZhZcwCTyYjIHPlzVyVRpErbsvrGiYG2MCJnrAB/Pn+pFV+uDZidojj5j+HjpXEmuIK8x4pyc5kARzg/lXW9ybZk+RjIYyJMD7VycWmbXZJ2aQyXVC8pEe5iM/Xmp+zLA2wZlYmCcFTwCc/4f16VXaLVwX2ggHk8Y5aT7/z9an0esKOWOSeckjB59TiYgHFDT2UnRJ2jfZWIjOT64+Y/b85qpsOVYNxBwJ9N0xOcZj3rr7R1ovFgYmDjpI2kHymCR9BXDZvgsygAAkLngZP+uDW+GXBGGSPJnQ97aySQYlpbM7h1HXEAipuyy5DbI3cheoQeFjM5MFRJzg89YXsBkaVXqRtPpEmeY/gK6NKQhJg7n8jGMEdB06g+XnNW5qgUaA12vvm2DtjMeNoUQGYjrADuAABkJiQKqtKBuZQZ3sobcXYsQIEnJJMA48iTmtBctqwt3cAmZLBmJIErHn+tcaWVW4cdRIB6xO3HmT6zNT9o+JOZF+4VIKkKVMySu3nAAJiOMCIE8nnCE3biNlpEAGeCB/ED2I967bV4kLgDauYznECT6yftXKLQ75n5BHh8ogcT6T9QfrndtspaGsg7WiPDgjhjkndPpu+00Wk0Vu7O2ZIwzkEAkGG2xAiCaK8wZQ3DBhJzw5P2OODRJqBsCjEqp46E5MecDjnHqam2Ow3sJ3KgjdBVRyu5+QYHHBP0Irvtaq3bttuTawl12Ahi3P+Y+81xae6PEYycxk+LzOMQJ/OrDWXgWBZd3HPHUxkczI+3HSXLaJaKLtH4k1N+3bTUadGQRAuKzOWAO5iVYFcScbY44JqX4Ps3WvvddVRFXIUBR7ACSecsxJ9T07tS9tg25AP8MCPQ/rBMfeo9PqCimY8QkAT6QT9z9/Suh/KlxcYqrMvoTdtmoOpC+GcCYjiYjp5SOPOotTq/D18vIkx+XIGfKqS1qREk8ifbiB74P8AXM1zUsVQnEAZPBbwgDMdBNcPBmiWzBPc68EmSfw+IHb9p/7qZ7uT5bRAjnjP/f6VzaZztuCTHP1g5qRz4r/uo+my6Y9pAP0Fetx2Z2T6cGY2zJ2gL5RiI65/TNS6e/L4/C0MMwc+UQRgc9ZqFyRbSP8ACD9e7mfvmp9PgrHW6s+v/wCRz/0j7DypOKoE3ZLeuhSdohQJMkEyJMg88/rHnMN64UUscPgMM4nMec8CB1n1rtvW1724IGLojAxDPEVWa0+Kx6sxPqf3eaIRTCToM699xVSeoJjkzwABAzJHr711C+zwCTABJ6lfMe+Yg9T6YqBcK4UkeE8GPwE/rVvpv79//kP5WyR+eaJxSCMmzkvTbuMGjByBHIkmYiOixxIGKj1es3EopbDQGwRAjn8uPznEt8+O57Mfrkz7yTVUWIuQDHP/AIj+ZoUU9lcmi95XEb/lfKkbYIbB9SfOc8QZC+N8IfCc7czwSCfEeM4PHzec0to/e4H+8zXbpwDYk894D9TbWT70qohu2UrMRxg5Wc+sc/xyOMV1XXZEYxJPAnpJAMfXy4nBxXVo0BKyAYZYnp41H6E/c0OoUQ+BiI9MvxTtMVug9PcI3NzM7fqSB9ZVh9MYzUVy7tubVJPSSMGYBED3mJp9Kf3SHruOev8Aekc1X3T4o/r5E/mfvUKO2at6LlLo4GARgEesY85OfqPauK/cZl2+bFoOIIG6MeZf8xjym0jk20JJmCPtuioE4sjoXE+s3boM+4AH0FKMVYmyXTowXcVLQA26MCRP/TPn5jGa6NFcU5glSCY4IiB5QDEDHn5VBqnO58nj/wCtw/wH2qw0Cjc6xgWXgdBFy/ED/KPsKJJVYRe6DS8STtAJ+VekDJMwcgDJn19a4r2tCuEHBBYkiSeTx7ecc+dThQEUgZKmT1M3INVFwTqLgPla/wDFKcIJilKi3saxn6cdM9JlienOT6eUV227JdZmDnMCJAknyEDr5x5YruyLrbiNx/F1P+C5/IVcaL+7P/xoPoQ8j2MD7CplFJ6Gno4i+BCycYE4kysEcnAz/wAQyK5rpjxzO3BjOcyB6Zj8uonru/KPr/4k/qJqTtYQ8jzX9Y/TFKkJsrVdmaF6dB6kEfkD1jkYort0lu7EGVicmWlR+s/QD1rtVQFYgCYUz1wzxXFqBDWoxJtgx1Hh5+5+9GmFss0bwQZEAloyZB//AKkfpmag016eZwTjqGkAe0bd335oNWYFyMQpiMRCvEVw2GIurBPzgfTGPas4wNGy2uPK85GOMgCOfqtR3UL3CeplSRyNgwRMeWIgYPMik+RbByDctg+o8OD58n71J2exN24SZMW8nJzvn7wPsKIxXYmyRiE2llKbpEwRJjoegiRiM1Peu+CGGBumOZ3fKCcyePTFcvZx3GzOc2uc8jTT99zf9R867Ezp9ITkm5knk5U588k/eiUaFFn/2Q=="));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.FAMILY));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.CLOTHES));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.COLOR));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.FRUIT));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.COOKING));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.MUSIC));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.NUMBER));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.SCHOOL));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.SPORT));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.TRAFFIC));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.VEGETABLE));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.WEATHER));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.HOSPITAL));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.RESTAURANT));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.ADJECTIVE));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.ACTION));
        return arrayListBasicEnglish;
    }

    ArrayList<Topic> createChildrenEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_CHILDREN);
        int courseId = course.getId();

        ArrayList<Topic> arrayListChildrenEnglish = new ArrayList<>();

        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS1));
        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS2));
        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS3));
        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS4));
        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS5));
        return arrayListChildrenEnglish;
    }

    ArrayList<Topic> createHighSchoolEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_HIGH_SCHOOL);
        int courseId = course.getId();

        ArrayList<Topic> arrayListHighSchoolEnglish = new ArrayList<>();
        arrayListHighSchoolEnglish.add(new Topic(courseId, TopicDAO.CLASS6));
        arrayListHighSchoolEnglish.add(new Topic(courseId, TopicDAO.CLASS7));
        arrayListHighSchoolEnglish.add(new Topic(courseId, TopicDAO.CLASS8));
        arrayListHighSchoolEnglish.add(new Topic(courseId, TopicDAO.CLASS9));
        arrayListHighSchoolEnglish.add(new Topic(courseId, TopicDAO.CLASS10));
        arrayListHighSchoolEnglish.add(new Topic(courseId, TopicDAO.CLASS11));
        arrayListHighSchoolEnglish.add(new Topic(courseId, TopicDAO.CLASS12));
        return arrayListHighSchoolEnglish;
    }

    ArrayList<Topic> createOfficeEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_OFFICE);
        int courseId = course.getId();

        ArrayList<Topic> arrayListOfficeEnglish = new ArrayList<>();
        arrayListOfficeEnglish.add(new Topic(courseId, TopicDAO.POSITION));
        arrayListOfficeEnglish.add(new Topic(courseId, TopicDAO.DEPARTMENT));
        arrayListOfficeEnglish.add(new Topic(courseId, TopicDAO.SUPPLY));
        arrayListOfficeEnglish.add(new Topic(courseId, TopicDAO.BENEFIT));
        arrayListOfficeEnglish.add(new Topic(courseId, TopicDAO.CONFERENCE));
        arrayListOfficeEnglish.add(new Topic(courseId, TopicDAO.MACHINES));
        arrayListOfficeEnglish.add(new Topic(courseId, TopicDAO.COMMON));
        return arrayListOfficeEnglish;
    }

    ArrayList<Topic> createProgrammingEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_PROGRAMMING);
        int courseId = course.getId();

        ArrayList<Topic> arrayListProgrammingEnglish = new ArrayList<>();
        arrayListProgrammingEnglish.add(new Topic(courseId, TopicDAO.STRUCTURE));
        arrayListProgrammingEnglish.add(new Topic(courseId, TopicDAO.JOBS));
        arrayListProgrammingEnglish.add(new Topic(courseId, TopicDAO.PERIPHERALS));
        arrayListProgrammingEnglish.add(new Topic(courseId, TopicDAO.MEETING));
        arrayListProgrammingEnglish.add(new Topic(courseId, TopicDAO.EQUIPMENT));
        arrayListProgrammingEnglish.add(new Topic(courseId, TopicDAO.TECHNOLOGY));
        return arrayListProgrammingEnglish;
    }

    ArrayList<Topic> createTravelEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_TRAVEL);
        int courseId = course.getId();

        ArrayList<Topic> arrayListTravelEnglish = new ArrayList<>();
        arrayListTravelEnglish.add(new Topic(courseId, TopicDAO.TOUR_GUIDE));
        arrayListTravelEnglish.add(new Topic(courseId, TopicDAO.AGENCY));
        arrayListTravelEnglish.add(new Topic(courseId, TopicDAO.HOTEL));
        arrayListTravelEnglish.add(new Topic(courseId, TopicDAO.SEA));
        arrayListTravelEnglish.add(new Topic(courseId, TopicDAO.PLANE));
        return arrayListTravelEnglish;
    }

    ArrayList<Topic> createIeltsCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.IELTS);
        int courseId = course.getId();

        ArrayList<Topic> arrayListIeltsEnglish = new ArrayList<>();
        arrayListIeltsEnglish.add(new Topic(courseId, TopicDAO.OVERVIEW));
        arrayListIeltsEnglish.add(new Topic(courseId, TopicDAO.LISTENING));
        arrayListIeltsEnglish.add(new Topic(courseId, TopicDAO.SPEAKING));
        arrayListIeltsEnglish.add(new Topic(courseId, TopicDAO.READING));
        arrayListIeltsEnglish.add(new Topic(courseId, TopicDAO.WRITING));
        return arrayListIeltsEnglish;
    }

    ArrayList<Topic> createToeicCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.TOEIC);
        int courseId = course.getId();

        ArrayList<Topic> arrayListToeicEnglish = new ArrayList<>();
        arrayListToeicEnglish.add(new Topic(courseId, TopicDAO.CONTRACTS));
        arrayListToeicEnglish.add(new Topic(courseId, TopicDAO.SHOPPING));
        arrayListToeicEnglish.add(new Topic(courseId, TopicDAO.MARKETING));
        arrayListToeicEnglish.add(new Topic(courseId, TopicDAO.MOVIES));
        arrayListToeicEnglish.add(new Topic(courseId, TopicDAO.ACCOUNTING));
        return arrayListToeicEnglish;
    }
}

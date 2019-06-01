#This is a maven project and runs on Java 8 (Because of use of lambda functions)


Check all the details related to the project in, Please go through these two files to check how the frameworks are implemented and what things are supported.

1. Created Frameworks explanation.txt
2. Fee calculator explanation.txt.

#Project explanation : 

#How to run: Open the project in any IDE, Go to class FeeCalculatorRunner and run the main Method.

Where you can see the Output: Because I have implemented SOUT report too and currently used that you will be able to see the output on the console.
If want to switch from SOUT mode to file mode You will need to change FeeCalculatorRunner: Line no 28 ReportType.SOUT to ReportType.CSV and you can check the generated CSV file in /src/main/resources/output.csv

#What is supported (For more info check Created Frameworks explanation.txt): 
1. Read from any source, Right now we have two implementation TXT and Excel but this can be easily extended to read from even Rest API.
2. Generate any number of report, Because I have created BatchRunner which can add any number of steps.
3. In future add more steps like After transform Load data into the system and then generate the report.
4. The framework can process any type of record not just transaction report so If in future we need to process some other type of data and generate the report based on that we can easily do that.

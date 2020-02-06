# Responsible Security Disclosure README

## Our Policy and Your Responsibility

### Purpose

This policy is intended to provide guidelines on submitting vulnerabilities  discovered on DOE CODE, an application hosted by the Department of Energy (DOE) Office of Scientific and Technical Information (OSTI). 

To read more about DOE OSTI’s security policies for all of DOE OSTI’s applications, read more: [**Vulnerability Disclosure Policy**](https://www.osti.gov/.well-known/security.txt)

If you believe you have found a vulnerability in DOE CODE, please reviewed the guidelines for submission by following the steps in the section detailing, “How to Submit a Report”.

### Scope

This security disclosure document covers the web application for DOE CODE, an application hosted by the Department of Energy (DOE) Office of Scientific and Technical Information (OSTI) at https://www.osti.gov/doecode.   This policy does not include any user submitted code base hosted on DOE CODE. However, we will make our best effort to notify the owner of any repository we receive a vulnerability report for.

### Overview

The DOE OSTI security policy is to cause no harm to the open source ecosystem by improving code and supporting security best practices.

If you discover potential vulnerabilities or security issues with DOE CODE, please see the “How to Submit a Report” section of this policy. For bugs that impact visitor usability or application performance, please report them to OSTI directly by emailing doecode@osti.gov with as many details about the potential issue (and reproducing it) as you can provide, or by adding to DOE CODE’s Github project, https://github.com/doecode.   

We recommend reporting security bugs and vulnerability bugs that you find to doecode@osti.gov and include the word “SECURITY” in the subject line.

Once your email has been received, within 48 hours of receipt, one of the DOE CODE project maintainer(s) will reach out to you acknowledging that they received your report and provide you with any steps requiring further actions or response. 

The DOE CODE project maintainer will forward the report to the OSTI Security Team, which will review the report. After the Security Team reviews your report, the project maintainer will make every effort to remain transparent and share information as the vulnerability validation process is completed.  If needed, the Security Team will then inform you when an announcement will occur letting all users of the project know about the security issue in the form of patch notes.

## How to Submit a Report

### Security Disclosure Guidelines

DOE OSTI will deal in good faith with end-users who discover, test and submit vulnerabilities or indicators of vulnerabilities in accordance with these guidelines.

You, the security researcher, are responsible for reporting security vulnerabilities to OSTI using the guidelines below. Please use <a href="https://cheatsheetseries.owasp.org/cheatsheets/Vulnerability_Disclosure_Cheat_Sheet.html">OWASP</a>’s guidelines for responsible reporting of security issues.

When a vulnerability is found, we ask the following:
* Please notify DOE OSTI of the vulnerability via email, doecode@osti.gov and include the word “SECURITY” in the subject line.
* Please do not publicly disclose any details of the vulnerability, indicator of vulnerability or the content of information rendered available by a vulnerability.
* Avoid submitting unvalidated reports from automated vulnerability scanners.
* Please do no harm and do not exploit any vulnerability beyond the minimal amount of testing required to prove that a vulnerability exists or to identify an indicator related to a vulnerability.
* Please do not intentionally access the content of any communications, data, or information transiting or stored on DOE OSTI information system(s) – except to the extent that the information is directly related to a vulnerability and the access is necessary to prove that the vulnerability exists.
* Please do not exfiltrate any data under any circumstances.
* Please do not conduct denial of service testing.
* Please do not conduct social engineering, including spear phishing.

When disclosing vulnerabilities, please include the following in your email:
* Your name and affiliation (if any).
* Submit only one vulnerability per report (email).
* Include the scope of the vulnerability. Let us know who could use this exploit.
* Document the reproducible steps needed to identify the vulnerability.
* Show how to exploit the vulnerability, give us an attack scenario. However, we ask that you please do no harm and do not exploit any found vulnerability beyond the minimal amount of testing required to prove that the vulnerability exists and steps to replicated.

After DOE OSTI has received a submitted report, OSTI will perform the following:
* Confirm receipt of the email with vulnerability with the original sender of the vulnerability email.
* Confirm the problem and determine its scope.
* Alert the original sender of the response efforts and when a fix will be expected.
* Perform a code audit to find any similar problems.
* Prepare fixes for the issue(s).
* Release fixes for the issue(s).

### End-User Compliance

You, the end-user, must comply with all applicable Federal, State, and local laws in connection with your security research activities or other participation in this vulnerability disclosure program.

DOE OSTI does not authorize, permit, or otherwise allow (expressly or impliedly) any person, including any individual, group of individuals, consortium, partnership, or any other business or legal entity to engage in any security research or vulnerability or threat disclosure activity that is inconsistent with this policy or the law. If you engage in any activities that are inconsistent with this policy or the law, you may be subject to criminal and/or civil liabilities.

To the extent that any security research or vulnerability disclosure activity involves the networks, systems, information, applications, products, or services of a non-DOE entity (e.g., other Federal departments or agencies; State, local, or tribal governments; private sector companies or persons; employees or personnel of any such entities; or any other such third party), that non-DOE OSTI third party may independently determine whether to pursue legal action or remedies related to such activities.

If you conduct your security research and vulnerability disclosure activities in accordance with the restrictions and guidelines set forth in this policy, (1) DOE OSTI will not initiate or recommend any law enforcement or civil lawsuits related to such activities, and (2) in the event of any law enforcement or civil action brought by anyone other than DOE OSTI, DOE OSTI will take steps to make known that your activities were conducted pursuant to and in compliance with this policy.

DOE OSTI may modify the terms of this policy or terminate the policy at any time.

## About DOE CODE

### Joining the DOE CODE Repository

DOE CODE is the U.S. Department of Energy’s (DOE) software services platform and search tool for collaboration, archiving, and discovery of scientific and business software funded by DOE. In order to join the DOE CODE GitHub community, please fill out the form located <a href="https://www.osti.gov/doecode/gitlab-signup">here</a>.

### DOE CODE Hosts Repositories

When hosting other contributor’s code, it is imperative that the files are managed responsibly.  A hosting platform that takes no precautions while accepting untrusted files could end up unknowingly becoming the distribution platform for a virus. To reduce the risk of malicious files being uploaded we use a whitelist of the following file types: <code>.zip</code>, <code>.tar</code>, <code>.tgz</code>, <code>.tar.gz</code>, and <code>.tar.bz2</code>.  

In general, it is good practice to isolate all the files from untrusted sources, e.g., unknown end-users, which will further mitigate the risk of hosting uploaded files in your project.  DOE OSTI’s DOE CODE application stores all uploaded archives outside of the root directory.  Hosting files in this manner helps to isolate any potential access to files malicious code could have.  

Additionally, we reduce the uploads folder permissions to further reduce potential risk.

### Sercurity.md Contributors

* Darel Finkbeiner
* Alex Higginbotham
* Rebel Powell
* Daniel Reeves
* Andrew Smith
* Tim Sowers
* Mary Beth West
* Lance Vowell
